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
package com.codename1.ui.geom;

/**
 *
 * @author shannah
 */
public final class GeneralPath  implements Shape {

    public static final int WIND_EVEN_ODD = PathIterator.WIND_EVEN_ODD;
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

    public GeneralPath() {
        this(WIND_NON_ZERO, BUFFER_SIZE);
    }

    public GeneralPath(int rule) {
        this(rule, BUFFER_SIZE);
    }

    public GeneralPath(int rule, int initialCapacity) {
        setWindingRule(rule);
        types = new byte[initialCapacity];
        points = new float[initialCapacity * 2];
    }

    public GeneralPath(GeneralPath shape) {
        this(WIND_NON_ZERO, BUFFER_SIZE);
        PathIterator p = shape.getPathIterator();
        setWindingRule(p.getWindingRule());
        append(p, false);
    }

    public void setWindingRule(int rule) {
        if (rule != WIND_EVEN_ODD && rule != WIND_NON_ZERO) {
            // awt.209=Invalid winding rule value
            throw new java.lang.IllegalArgumentException("Invalid winding rule"); //$NON-NLS-1$
        }
        this.rule = rule;
    }

    public int getWindingRule() {
        return rule;
    }

    /**
     * Checks points and types buffer size to add pointCount points. If necessary realloc buffers to enlarge size.   
     * @param pointCount - the point count to be added in buffer
     */
    void checkBuf(int pointCount, boolean checkMove) {
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
    }

    public void lineTo(float x, float y) {
        checkBuf(2, true);
        types[typeSize++] = PathIterator.SEG_LINETO;
        points[pointSize++] = x;
        points[pointSize++] = y;
    }

    public void quadTo(float x1, float y1, float x2, float y2) {
        checkBuf(4, true);
        types[typeSize++] = PathIterator.SEG_QUADTO;
        points[pointSize++] = x1;
        points[pointSize++] = y1;
        points[pointSize++] = x2;
        points[pointSize++] = y2;
    }

    public void curveTo(float x1, float y1, float x2, float y2, float x3, float y3) {
        checkBuf(6, true);
        types[typeSize++] = PathIterator.SEG_CUBICTO;
        points[pointSize++] = x1;
        points[pointSize++] = y1;
        points[pointSize++] = x2;
        points[pointSize++] = y2;
        points[pointSize++] = x3;
        points[pointSize++] = y3;
    }

    public void closePath() {
        if (typeSize == 0 || types[typeSize - 1] != PathIterator.SEG_CLOSE) {
            checkBuf(0, true);
            types[typeSize++] = PathIterator.SEG_CLOSE;
        }
    }

    public void append(GeneralPath shape, boolean connect) {
        PathIterator p = shape.getPathIterator();
        append(p, connect);
    }

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
    }

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

    public void reset() {
        typeSize = 0;
        pointSize = 0;
    }

    


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

    public Rectangle getBounds() {
        float[] r = getBounds2D();
        return new Rectangle((int)r[0], (int)r[1], (int)r[2], (int)r[3]);
        
    }

    

    public PathIterator getPathIterator() {
        return new Iterator(this);
    }

   


}
