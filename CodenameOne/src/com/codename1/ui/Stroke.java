/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
