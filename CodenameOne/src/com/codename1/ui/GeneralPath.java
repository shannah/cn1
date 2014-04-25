/*
 * Copyright (c) 2012, Codename One and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Codename One designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *  
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 * 
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 * Please contact Codename One through http://www.codenameone.com/ if you 
 * need additional information or have any questions.
 */
package com.codename1.ui;

import com.codename1.impl.CodenameOneImplementation;
import com.codename1.ui.geom.PathIterator;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;

/**
 * A general geometric path, consisting of any number of subpaths constructed
 * out of straight lines and cubic or quadratic Bezier curves. The inside of the
 * curve is defined for drawing purposes by a winding rule. Either the
 * {@link #WIND_EVEN_ODD} or {@link #WIND_NON_ZERO} winding rule can be chosen.
 *
 * <h4>A drawing of a GeneralPath</h4>
 * 
 * <img src="http://developer.classpath.org/doc/java/awt/geom/doc-files/GeneralPath-1.png"/>
 *
 * <p>The {@link #WIND_EVEN_ODD} winding rule defines a point as inside a path if: A ray from the
 * point towards infinity in an arbitrary direction intersects the path an odd
 * number of times. Points {@literal A} and {@literal C} in the image are considered to be outside the
 * path. (both intersect twice) Point {@literal B} intersects once, and is inside.</p>
 *
 * <p>The {@link #WIND_NON_ZERO} winding rule defines a point as inside a path if: The path
 * intersects the ray in an equal number of opposite directions. Point {@link A} in the
 * image is outside (one intersection in the 'up' direction, one in the 'down'
 * direction) Point {@literal B} in the image is inside (one intersection 'down') Point C
 * in the image is inside (two intersections in the 'down' direction)</p>
 * 
 * <!--(Note:  This description and image were copied from <a href="http://developer.classpath.org/doc/java/awt/geom/GeneralPath.html">the GNU classpath</a>
 * docs).  License here http://www.gnu.org/licenses/licenses.html#FDL 
 * -->
 *
 * @author shannah
 *
 * @see com.codename1.ui.Graphics#drawShape
 * @see com.codename1.ui.Graphics#fillShape
 */
public final class GeneralPath implements Shape {
    
    private static final int FILL_CACHE=0;
    private static final int STROKE_CACHE=1;
    private Stroke cachedStroke = null;
    private Object[] textureCache = new Object[2];
    private boolean dirty = true;
    Object getAlphaMask(Stroke stroke){
        if ( dirty ){
            for ( int i=0; i<textureCache.length; i++){
                textureCache[i] = null;
            }
            dirty = false;
        }
        int cacheType = FILL_CACHE;
        if ( stroke != null ){
            cacheType = STROKE_CACHE;
            if ( cachedStroke != null && !cachedStroke.equals(stroke)){
                textureCache[STROKE_CACHE] = null;
            }
            cachedStroke = stroke;
        }
        if ( textureCache[cacheType] == null){
            textureCache[cacheType] = Display.getInstance().getImplementation().createAlphaMask(this, stroke);
        }
        return textureCache[cacheType];
    }
    
    void deleteAlphaMasks(){
        CodenameOneImplementation impl = Display.getInstance().getImplementation();
        for ( int i=0; i<textureCache.length; i++){
            Object tex = textureCache[i];
            if ( tex != null ){
                impl.deleteAlphaMask(tex);
                textureCache[i] = null;
            }
        }
    }

    /**
     * Same constant as {@link PathIterator#WIND_EVEN_ODD}
     */
    public static final int WIND_EVEN_ODD = PathIterator.WIND_EVEN_ODD;
    /**
     * Same constant as {@link PathIterator#WIND_NON_ZERO}
     */
    public static final int WIND_NON_ZERO = PathIterator.WIND_NON_ZERO;

    /**
     * The buffers size
     */
    private static final int BUFFER_SIZE = 10;
    
    /**
     * The buffers capacity
     */
    private static final int BUFFER_CAPACITY = 10;

    /**
     * The point's types buffer
     */
    private byte[] types;
    
    /**
     * The points buffer
     */
    private float[] points;
    
    /**
     * The point's type buffer size
     */
    private int typeSize;
    
    /**
     * The points buffer size
     */
    private int pointSize;
    
    /**
     * The path rule 
     */
    private int rule;

    /**
     * The space amount in points buffer for different segmenet's types
     */
    private static int pointShift[] = {
            2,  // MOVETO
            2,  // LINETO
            4,  // QUADTO
            6,  // CUBICTO
            0}; // CLOSE

    /*
     * GeneralPath path iterator 
     */
    private class Iterator implements PathIterator {

        /**
         * The current cursor position in types buffer
         */
        int typeIndex;
        
        /**
         * The current cursor position in points buffer
         */
        int pointIndex;
        
        /**
         * The source GeneralPath object
         */
        GeneralPath p;
        
        /**
         * Constructs a new GeneralPath.Iterator for given general path
         * @param path - the source GeneralPath object
         */
        Iterator(GeneralPath path) {
            this.p = path;
            
        }

        public int getWindingRule() {
            return p.getWindingRule();
        }

        public boolean isDone() {
            return typeIndex >= p.typeSize;
        }

        public void next() {
            typeIndex++;
        }

        public int currentSegment(double[] coords) {
            if (isDone()) {
                // awt.4B=Iterator out of bounds
                throw new IndexOutOfBoundsException("Path done"); //$NON-NLS-1$
            }
            int type = p.types[typeIndex];
            int count = GeneralPath.pointShift[type];
            for (int i = 0; i < count; i++) {
                coords[i] = p.points[pointIndex + i];
            }
            
            pointIndex += count;
            return type;
        }

        public int currentSegment(float[] coords) {
            if (isDone()) {
                // awt.4B=Iterator out of bounds
                throw new IndexOutOfBoundsException("Path done"); //$NON-NLS-1$
            }
            int type = p.types[typeIndex];
            int count = GeneralPath.pointShift[type];
            System.arraycopy(p.points, pointIndex, coords, 0, count);
            
            pointIndex += count;
            return type;
        }

    }

    /**
     * Constructs a GeneralPath with the default ({@link #WIND_NON_ZERO}) winding rule and initial capacity (10).
     */
    public GeneralPath() {
        this(WIND_NON_ZERO, BUFFER_SIZE);
    }

    /**
     * Constructs a GeneralPath with a specific winding rule and the default initial capacity (10).
     * @param rule The winding rule.  One of {@link #WIND_NON_ZERO} and {@link #WIND_EVEN_ODD}
     * @see #WIND_NON_ZERO
     * @see #WIND_EVEN_ODD
     */
    public GeneralPath(int rule) {
        this(rule, BUFFER_SIZE);
    }

    /**
     * Constructs a GeneralPath with a specific winding rule and the initial capacity. The initial capacity should be the approximate number of path segments to be used.
     * @param rule The winding rule.  ({@link #WIND_NON_ZERO} or {@link #WIND_EVEN_ODD}).
     * @param initialCapacity the inital capacity, in path segments
     */
    public GeneralPath(int rule, int initialCapacity) {
        setWindingRule(rule);
        types = new byte[initialCapacity];
        points = new float[initialCapacity * 2];
    }

    /**
     * Constructs a GeneralPath from an arbitrary shape object. The Shapes PathIterator path and winding rule will be used.
     * @param shape 
     */
    public GeneralPath(Shape shape) {
        this(WIND_NON_ZERO, BUFFER_SIZE);
        PathIterator p = shape.getPathIterator();
        setWindingRule(p.getWindingRule());
        append(p, false);
    }

    /**
     * Sets the path's winding rule, which controls which areas are considered 'inside' or 'outside' the path on drawing. Valid rules are {@link #WIND_EVEN_ODD} for an even-odd winding rule, or {@link #WIND_NON_ZERO} for a non-zero winding rule.
     * @param rule the rule. ({@link #WIND_NON_ZERO} or {@link #WIND_EVEN_ODD}).
     */
    public void setWindingRule(int rule) {
        if (rule != WIND_EVEN_ODD && rule != WIND_NON_ZERO) {
            // awt.209=Invalid winding rule value
            throw new java.lang.IllegalArgumentException("Invalid winding rule"); //$NON-NLS-1$
        }
        dirty = true;
        this.rule = rule;
    }

    /**
     * Returns the path's current winding rule.
     * @return {@link #WIND_NON_ZERO} or {@link #WIND_EVEN_ODD}
     */
    public int getWindingRule() {
        return rule;
    }

    /**
     * Checks points and types buffer size to add pointCount points. If necessary realloc buffers to enlarge size.   
     * @param pointCount - the point count to be added in buffer
     */
    private void checkBuf(int pointCount, boolean checkMove) {
        if (checkMove && typeSize == 0) {
            // awt.20A=First segment should be SEG_MOVETO type
            throw new IndexOutOfBoundsException("First segment must be a moveto"); //$NON-NLS-1$
        }
        if (typeSize == types.length) {
            byte tmp[] = new byte[typeSize + BUFFER_CAPACITY];
            System.arraycopy(types, 0, tmp, 0, typeSize);
            types = tmp;
        }
        if (pointSize + pointCount > points.length) {
            float tmp[] = new float[pointSize + Math.max(BUFFER_CAPACITY * 2, pointCount)];
            System.arraycopy(points, 0, tmp, 0, pointSize);
            points = tmp;
        }
    }

    /**
     * Adds a new point to a path.
     * @param x the x-coordinate.
     * @param y the y-coordinate.
     */
    public void moveTo(float x, float y) {
        if (typeSize > 0 && types[typeSize - 1] == PathIterator.SEG_MOVETO) {
            points[pointSize - 2] = x;
            points[pointSize - 1] = y;
        } else {
            checkBuf(2, false);
            types[typeSize++] = PathIterator.SEG_MOVETO;
            points[pointSize++] = x;
            points[pointSize++] = y;
        }
        dirty = true;
    }

    /**
     * Appends a straight line to the current path.
     * @param x x coordinate of the line endpoint.
     * @param y  y coordinate of the line endpoint.
     */
    public void lineTo(float x, float y) {
        checkBuf(2, true);
        types[typeSize++] = PathIterator.SEG_LINETO;
        points[pointSize++] = x;
        points[pointSize++] = y;
        dirty = true;
    }

    /**
     * Appends a quadratic Bezier curve to the current path.
     * @param x1 x coordinate of the control point
     * @param y1 y coordinate of the control point
     * @param x2 x coordinate of the curve endpoint.
     * @param y2 y coordinate of the curve endpoint.
     */
    public void quadTo(float x1, float y1, float x2, float y2) {
        checkBuf(4, true);
        types[typeSize++] = PathIterator.SEG_QUADTO;
        points[pointSize++] = x1;
        points[pointSize++] = y1;
        points[pointSize++] = x2;
        points[pointSize++] = y2;
        dirty = true;
    }

    /**
     * Appends a cubic Bezier curve to the current path.
     * @param x1 x coordinate of the first control point
     * @param y1  y coordinate of the first control point
     * @param x2 x coordinate of the second control point
     * @param y2 y coordinate of the second control point
     * @param x3 x coordinate of the curve endpoint.
     * @param y3 y coordinate of the curve endpoint.
     */
    public void curveTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        checkBuf(6, true);
        types[typeSize++] = PathIterator.SEG_CUBICTO;
        points[pointSize++] = x1;
        points[pointSize++] = y1;
        points[pointSize++] = x2;
        points[pointSize++] = y2;
        points[pointSize++] = x3;
        points[pointSize++] = y3;
        dirty = true;
    }

    /**
     * Closes the current subpath by drawing a line back to the point of the last moveTo, unless the path is already closed.
     */
    public void closePath() {
        if (typeSize == 0 || types[typeSize - 1] != PathIterator.SEG_CLOSE) {
            checkBuf(0, true);
            types[typeSize++] = PathIterator.SEG_CLOSE;
            dirty = true;
        }
    }

    /**
     * Appends the segments of a Shape to the path. If connect is {@literal true}, the new path segments are connected to the existing one with a line. The winding rule of the Shape is ignored.
     * @param shape  the shape (null not permitted).
     * @param connect whether to connect the new shape to the existing path.
     */
    public void append(Shape shape, boolean connect) {
        PathIterator p = shape.getPathIterator();
        append(p, connect);
        dirty = true;
    }

    /**
     * Appends the segments of a PathIterator to this GeneralPath. Optionally, the initial {@link PathIterator#SEG_MOVETO} segment of the appended path is changed into a {@link PathIterator#SEG_LINETO} segment.
     * @param path the PathIterator specifying which segments shall be appended (null not permitted).
     * @param connect {@literal true} for substituting the initial {@link PathIterator#SEG_MOVETO} segment by a {@link PathIterator#SEG_LINETO}, or false for not performing any substitution. If this {@code GeneralPath} is currently empty, connect is assumed to be {@literal false}, thus leaving the initial {@link PathIterator#SEG_MOVETO} unchanged.
     */
    public void append(PathIterator path, boolean connect) {
        while (!path.isDone()) {
            float coords[] = new float[6];
            switch (path.currentSegment(coords)) {
            case PathIterator.SEG_MOVETO:
                if (!connect || typeSize == 0) {
                    moveTo(coords[0], coords[1]);
                    break;
                }
                if (types[typeSize - 1] != PathIterator.SEG_CLOSE &&
                    points[pointSize - 2] == coords[0] &&
                    points[pointSize - 1] == coords[1])
                {
                    break;
                }
            // NO BREAK;
            case PathIterator.SEG_LINETO:
                lineTo(coords[0], coords[1]);
                break;
            case PathIterator.SEG_QUADTO:
                quadTo(coords[0], coords[1], coords[2], coords[3]);
                break;
            case PathIterator.SEG_CUBICTO:
                curveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
                break;
            case PathIterator.SEG_CLOSE:
                closePath();
                break;
            }
            path.next();
            connect = false;
        }
        dirty = true;
    }

    /**
     * Returns the current appending point of the path.
     * @return 2-element array of the form {@code [x,y]} representing {@code x} and {@code y} coordinate of the current appending point of the path..
     */
    public float[] getCurrentPoint() {
        if (typeSize == 0) {
            return null;
        }
        int j = pointSize - 2;
        if (types[typeSize - 1] == PathIterator.SEG_CLOSE) {

            for (int i = typeSize - 2; i > 0; i--) {
                int type = types[i];
                if (type == PathIterator.SEG_MOVETO) {
                    break;
                }
                j -= pointShift[type];
            }
        }
        return new float[]{points[j], points[j + 1]};
    }

    /**
     * Resets the path. All points and segments are destroyed.
     */
    public void reset() {
        typeSize = 0;
        pointSize = 0;
        dirty = true;
    }

    

    /**
     * Returns the path's bounding box, in float precision.
     * @return 4-element array of the form {@code [x, y, width, height]}.
     */
    public float[] getBounds2D() {
        float rx1, ry1, rx2, ry2;
        if (pointSize == 0) {
            rx1 = ry1 = rx2 = ry2 = 0.0f;
        } else {
            int i = pointSize - 1;
            ry1 = ry2 = points[i--];
            rx1 = rx2 = points[i--];
            while (i > 0) {
                float y = points[i--];
                float x = points[i--];
                if (x < rx1) {
                    rx1 = x;
                } else
                    if (x > rx2) {
                        rx2 = x;
                    }
                if (y < ry1) {
                    ry1 = y;
                } else
                    if (y > ry2) {
                        ry2 = y;
                    }
            }
        }
        return new float[]{rx1, ry1, rx2 - rx1, ry2 - ry1};
    }

    /**
     * Returns the path's bounding box.
     * @return The bounding box of the path.
     */
    public Rectangle getBounds() {
        float[] r = getBounds2D();
        return new Rectangle((int)r[0], (int)r[1], (int)r[2], (int)r[3]);
        
    }

    

    /**
     * Creates a PathIterator for iterating along the segments of the path.
     * @return 
     */
    public PathIterator getPathIterator() {
        return new Iterator(this);
    }


    

}
