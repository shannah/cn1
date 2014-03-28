/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.codename1.ui.geom;

import java.util.ArrayList;

/**
 *
 * @author shannah
 */
public interface PathIterator {
    static final ArrayList<PathIterator> pool = new ArrayList<PathIterator>();
    
    public static final int SEG_CLOSE = 1;
    public static final int SEG_CUBICTO = 2;
    public static final int SEG_LINETO = 3;
    public static final int SEG_MOVETO = 4;
    public static final int SEG_QUADTO = 5;
    public static final int WIND_EVEN_ODD = 0;
    public static final int WIND_NON_ZERO = 1;
    
    
    public int currentSegment(double[] coords);
    public int currentSegment(float[] coords);
    public int getWindingRule();
    public boolean isDone();
    public void next();
    
}
