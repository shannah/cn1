/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codename1.ui.geom;

/**
 *
 * @author shannah
 */
public interface PathIterator {

    public static final int WIND_EVEN_ODD = 0;
    public static final int WIND_NON_ZERO = 1;

    public static final int SEG_MOVETO  = 0;
    public static final int SEG_LINETO  = 1;
    public static final int SEG_QUADTO  = 2;
    public static final int SEG_CUBICTO = 3;
    public static final int SEG_CLOSE   = 4;

    public int getWindingRule();

    public boolean isDone();

    public void next();

    public int currentSegment(float[] coords);

    public int currentSegment(double[] coords);

}
