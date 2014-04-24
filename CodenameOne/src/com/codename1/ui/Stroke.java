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

/**
 *
 * @author shannah
 */
public class Stroke {
    public static final int JOIN_MITER = 0;
    public static final int JOIN_ROUND = 1;
    public static final int JOIN_BEVEL = 2;
    public static final int CAP_BUTT = 0;
    public static final int CAP_ROUND = 1;
    public static final int CAP_SQUARE = 2;
    
    
    private int joinStyle=0;
    private int capStyle=0;
    private float lineWidth=1f;
    private float miterLimit=0f;
    
    public Stroke(float lineWidth, int capStyle, int joinStyle, float miterLimit){
        this.lineWidth = lineWidth;
        this.capStyle = capStyle;
        this.joinStyle = joinStyle;
        this.miterLimit = miterLimit;
    }
    
    public Stroke(){
        
    }

    /**
     * @return the joinStyle
     */
    public int getJoinStyle() {
        return joinStyle;
    }

    /**
     * @param joinStyle the joinStyle to set
     */
    public void setJoinStyle(int joinStyle) {
        this.joinStyle = joinStyle;
    }

    /**
     * @return the capStyle
     */
    public int getCapStyle() {
        return capStyle;
    }

    /**
     * @param capStyle the capStyle to set
     */
    public void setCapStyle(int capStyle) {
        this.capStyle = capStyle;
    }

    /**
     * @return the lineWidth
     */
    public float getLineWidth() {
        return lineWidth;
    }

    /**
     * @param lineWidth the lineWidth to set
     */
    public void setLineWidth(float lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * @return the miterLimit
     */
    public float getMiterLimit() {
        return miterLimit;
    }

    /**
     * @param miterLimit the miterLimit to set
     */
    public void setMiterLimit(float miterLimit) {
        this.miterLimit = miterLimit;
    }
}
