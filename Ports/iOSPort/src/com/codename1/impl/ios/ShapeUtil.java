/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.impl.ios;

import com.codename1.ui.GeneralPath;
import com.codename1.ui.geom.PathIterator;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.geom.Shape;





/**
 *
 * @author shannah
 */
public class ShapeUtil {
    
    /**
     * Returns the point in the given set of {@code points} that is closest to the
     * {@code src} point.
     * @param src The source point.  2-element float array representing x,y coord.
     * @param points Array of points.  Of form [x1,y1,x2,y2,...,xn,yn]
     * @return The point in {@code points} that is closest to {@code src}.  A 2-element float array.
     */
    static float[] closest(float[] src, float[] points) {
        float[] min = new float[2];
        float dist = -1;
        float[] a = new float[2];

        for (int i = 0; i < points.length; i += 2) {
            a[0] = points[i];
            a[1] = points[i + 1];
            float tmpDst = distanceSquared(src, a);
            if (dist == -1 || tmpDst < dist) {
                dist = tmpDst;
                System.arraycopy(a, 0, min, 0, 2);
            }

        }
        return min;
    }

    /**
     * The square of the distance between two points
     * @param a Point a.  Of form [x,y] (i.e. 2-element float array)
     * @param b Point b. Of form [x,y] (i.e. 2-element float array)
     * @return Square of distance between a and b.
     */
    static float distanceSquared(float[] a, float[] b) {
        float xDiff = a[0]-b[0];
        float yDiff = a[1]-b[1];
        return xDiff*xDiff + yDiff*yDiff;
    }

   
    /**
     * Generates the intersection of a given shape and a given rectangle.  Only supported convex polygons.
     *
     * @param r A rectangle.
     * @param s A shape
     * @return The shape that is the intersected area of the shape and
     * rectangle.
     */
    public static Shape intersection(Rectangle r, Shape s) {
        Shape segmentedShape = segmentShape(r, s);
        PathIterator it = segmentedShape.getPathIterator(null);
        GeneralPath out = new GeneralPath();
        float[] buf = new float[6];
        boolean started = false;
        int count = 0;

        float x1 = r.getX();
        float x2 = r.getX() + r.getWidth();
        float y1 = r.getY();
        float y2 = r.getY() + r.getHeight();

        //System.out.println("x1` is "+x1);
        
        float minX = -1;
        float minY = -1;
        float maxX = -1;
        float maxY = -1;

        float prevX=0; 
        float prevY=0;
        
        while (!it.isDone()) {
            int type = it.currentSegment(buf);

            switch (type) {

                case PathIterator.SEG_CLOSE:
                    //System.out.println("Closing path");
                    out.closePath();
                    break;

                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                    if (buf[0] < x1) {
                        buf[0] = x1;
                    } else if (buf[0] > x2) {
                        buf[0] = x2;
                    }
                    if (buf[1] < y1) {
                        buf[1] = y1;
                    } else if (buf[1] > y2) {
                        buf[1] = y2;
                    }

                    if (!started || (buf[0] < minX)) {
                        minX = buf[0];
                    }
                    if (!started || (buf[0] > maxX)) {
                        maxX = buf[0];
                    }

                    if (!started || (buf[1] < minY)) {
                        minY = buf[1];
                    }
                    if (!started || (buf[1] > maxY)) {
                        maxY = buf[1];
                    }

                    if (type == PathIterator.SEG_MOVETO) {
                        
                        //System.out.println("Moving to "+buf[0]+","+buf[1]);
                        out.moveTo(buf[0], buf[1]);
                    } else { // type == PathITerator.SEG_LINETO
                        
                        if ( prevX != buf[0] || prevY != buf[1]){
                            //System.out.println("Line to "+buf[0]+","+buf[1]);
                            out.lineTo(buf[0], buf[1]);
                        }
                    }
                    prevX = buf[0];
                    prevY = buf[1];
                    started = true;
                    count++;
                    break;
                default:
                    throw new RuntimeException("Intersection only supports polygons currently");
            }
            it.next();
            
        }

        if (maxX - minX <= 1f || maxY - minY <= 1f) {
            return null;
        }

        return out;

    }

    /**
     * Segments a given shape so that all points of the shape that intersect the
     * provided rectangle edges are nodes of the shape path. This operation
     * makes it easier to form the intersection.
     * 
     * Only supports convex polygons.
     *
     * @param r A rectangle.
     * @param s A shape
     * @return A shape that is identical to the input shape except that it may
     * include additional path segments so that all points of intersection are
     * start/end points of a segment.
     */
    static Shape segmentShape(Rectangle r, Shape s) {
        PathIterator it = s.getPathIterator(null);
        GeneralPath out = new GeneralPath();
        float[] buf = new float[6];     // buffer to hold segment coordinates from PathIterator.currentSegment
        float[] curr = new float[2];    // Placeholder for current point
        float[] prev = new float[2];    // Placeholder for previous point
        float[] mark = new float[2];    // Placeholder for the moveTo point
        float[] buf4 = new float[4];    // Reusable buffer to hold two points.

        float prevX = -1;               // Placeholder for previous X coord.
        float prevY = -1;               // Placeholder for previous Y coord.
        float currX = 0;                // Placeholder for current X coord.
        float currY = 0;                // Placeholder for current Y coord.
        float[] intersects = null;      // Placeholder for intersection points
        while (!it.isDone()) {
            
            int type = it.currentSegment(buf);
            switch (type) {
                
                case PathIterator.SEG_MOVETO:
                    // Move to segment is transferred straight through
                    prevX = prev[0] = mark[0] = buf[0];
                    prevY = prev[1] = mark[1] = buf[1];
                    out.moveTo(prevX, prevY);
                    //System.out.println("Moving to "+prevX+","+prevY);
                    break;

                case PathIterator.SEG_LINETO:
                    // Line Segment may need to be partitioned if it crosses
                    // an edge of the rectangle.
                    currX = curr[0] = buf[0];
                    currY = curr[1] = buf[1];

                    // Check if line intersects rectangle
                    intersects = intersection(prevX, prevY, currX, currY, r);
                    //System.out.println("Looking for intersections between "+prevX+","+prevY+" and "+currX+","+currY);
                    //System.out.println("Intersects: "+intersects[0]+", "+intersects[1]+"  "+intersects[2]+","+intersects[3]);
                    if (intersects[4] > 1) {
                        //System.out.println("2 intersections");
                        // 2 points of intersection found.  stored in 
                        // 0..3 positions
                        System.arraycopy(intersects, 0, buf4, 0, 4);

                        // First line will go from previous point to the 
                        // intersect point closest to it
                        float[] p1 = closest(prev, buf4);

                        // Second line will go from first intersection point
                        // to second intersect point.
                        float[] p2 = closest(curr, buf4);
                        //System.out.println("Line to "+p1[0]+","+p1[1]);
                        out.lineTo(p1[0], p1[1]);
                        //System.out.println("Line to "+p2[0]+","+p2[1]);
                        out.lineTo(p2[0], p2[1]);

                        // Third line goes from 2nd intersection point to 
                        // current point (i.e. original end point of line segment)
                        //System.out.println("Line to "+currX+","+currY);
                        out.lineTo(currX, currY);

                    } else if (intersects[4] == 1) {
                        //System.out.println("1 intersection");
                        // 1 point of intersection found.  Stored in 0..1 positions.

                        // First line goes from previous point to intersection point
                        //System.out.println("Line to "+intersects[0]+","+intersects[1]);
                        out.lineTo(intersects[0], intersects[1]);

                        // Second line goes from intersection point to current point
                        // (i.e. original end point of line segment)
                        //System.out.println("Line to "+currX+","+currY);
                        out.lineTo(currX, currY);
                    } else {
                        //System.out.println("No intersections");
                        // No intersection points were found... just draw the line.
                        //System.out.println("Line to "+currX+","+currY);
                        out.lineTo(currX, currY);
                    }

                    // Set current position to prev for next iteration.
                    prevX = currX;
                    prevY = currY;
                    float[] tmp = curr;
                    curr = prev;
                    prev = curr;

                    break;
                case PathIterator.SEG_CLOSE:

                    // Closing the path.  Need to check if there is an intersection
                    // on this last closing path.
                    currX = curr[0] = mark[0];
                    currY = curr[1] = mark[1];
                    intersects = intersection(prevX, prevY, currX, currY, r);
                    if (intersects[4] > 1) {
                        System.arraycopy(intersects, 0, buf4, 0, 4);
                        float[] p1 = closest(prev, buf4);
                        float[] p2 = closest(curr, buf4);
                        out.lineTo(p1[0], p1[1]);
                        out.lineTo(p2[0], p2[1]);
                        out.closePath();

                    } else if (intersects[4] == 1) {
                        out.lineTo(intersects[0], intersects[1]);
                        out.closePath();
                    } else {
                        out.closePath();
                    }
                    break;
                default:
                    throw new RuntimeException("Shape segmentation only supported for polygons");
            }
            it.next();
        }
        return out;
    }

    static float[] intersection(float x1, float y1, float x2, float y2, Rectangle rect) {
        float[] out = new float[5];
        out[4] = 0;

        int rx1 = rect.getX();
        int rx2 = rect.getX() + rect.getWidth();
        int ry1 = rect.getY();
        int ry2 = rect.getY() + rect.getHeight();
        int numIntersections = 0;
        float[] buf = intersection(x1, y1, x2, y2, rx1, ry1, rx1, ry2);
        if (buf != null) {
            numIntersections++;
            out[4] = numIntersections;
            if (numIntersections == 1) {
                out[0] = buf[0];
                out[1] = buf[1];
            } else if (numIntersections == 2) {
                out[2] = buf[0];
                out[3] = buf[1];
            }
        }

        buf = intersection(x1, y1, x2, y2, rx1, ry1, rx2, ry1);

        if (buf != null) {
            numIntersections++;
            out[4] = numIntersections;
            if (numIntersections == 1) {
                out[0] = buf[0];
                out[1] = buf[1];
            } else if (numIntersections == 2) {
                out[2] = buf[0];
                out[3] = buf[1];
            }
        }
        if (numIntersections >= 2) {
            return out;
        }
        buf = intersection(x1, y1, x2, y2, rx1, ry2, rx2, ry2);
        if (buf != null) {
            numIntersections++;
            out[4] = numIntersections;
            if (numIntersections == 1) {
                out[0] = buf[0];
                out[1] = buf[1];
            } else if (numIntersections == 2) {
                out[2] = buf[0];
                out[3] = buf[1];
            }
        }
        if (numIntersections >= 2) {
            return out;
        }
        buf = intersection(x1, y1, x2, y2, rx2, ry1, rx2, ry2);
        if (buf != null) {
            numIntersections++;
            out[4] = numIntersections;
            if (numIntersections == 1) {
                out[0] = buf[0];
                out[1] = buf[1];
            } else if (numIntersections == 2) {
                out[2] = buf[0];
                out[3] = buf[1];
            }
        }

        return out;
    }

    /**
     * Finds the intersection between two lines. Or null if there is no intersection.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param x3
     * @param y3
     * @param x4
     * @param y4
     * @return 
     */
    static float[] intersection(
            float x1,
            float y1,
            float x2,
            float y2,
            float x3, float y3, float x4,
            float y4
    ) {
        //System.out.println("Checking intersection of "+x1+","+y1+"-"+x2+","+y2+" with "+x3+","+y3+"-"+x4+","+y4);
        float d = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
        if (d == 0) {
            return null;
        }

        float xi = ((x3 - x4) * (x1 * y2 - y1 * x2) - (x1 - x2) * (x3 * y4 - y3 * x4)) / d;
        
        if ( xi < Math.min(x1, x2) || xi > Math.max(x1, x2) || xi <Math.min(x3,x4) || xi > Math.max(x3,x4)){
            return null;
        }
        
        float yi = ((y3 - y4) * (x1 * y2 - y1 * x2) - (y1 - y2) * (x3 * y4 - y3 * x4)) / d;
        if ( yi < Math.min(y1,y2) || yi > Math.max(y1,y2) || yi < Math.min(y3, y4) || yi > Math.max(y3, y4)){
            return null;
        }
        //System.out.println("Intersects at "+xi+","+yi);
        return new float[]{xi, yi};
    }
    
    
   
    
   
    
    
    
    
    
}
