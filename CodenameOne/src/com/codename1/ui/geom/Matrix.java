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
public class Matrix {
    private float[] data;
    
    public Matrix(float[] m){
        switch ( m.length ){
            case 1:
                data = new float[]{ 
                    m[0], 0, 0, 0,
                    0, m[0], 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1
                };
                break;
                
            case 2:
                data = new float[]{
                    m[0], 0, 0, 0,
                    0, m[1], 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1
                };
                break;
            case 4:
                // This is just a 2D transformation
                data = new float[]{
                    m[0], m[1], 0, 0,
                    m[2], m[3], 0, 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1
                };
                break;
            case 6:
                data = new float[]{
                    m[0], m[1], m[2], 0,
                    m[3], m[4], m[5], 0,
                    0, 0, 1, 0,
                    0, 0, 0, 1
                    
                };
                break;
            case 9:
                data = new float[] {
                    m[0], m[1], m[2], 0,
                    m[3], m[4], m[5], 0,
                    m[6], m[6], m[7], 0,
                    0, 0, 0, 1};
                break;
            case 12:
                data = new float[]{
                    m[0], m[1], m[2], m[3],
                    m[4], m[5], m[6], m[7],
                    m[8], m[9], m[10], m[11],
                    0,0,0,1
                    
                };
                break;
            case 16:
                data = new float[]{
                    m[0], m[1], m[2], m[3],
                    m[4], m[5], m[6], m[7],
                    m[8], m[9], m[10], m[11],
                    m[12], m[13], m[14], m[15],
                };
                break;
            default:
                throw new IllegalArgumentException("Transforms must be array of length 1, 2, 4, 6, 9, 12, or 16");
        }
    }
    public float[] getData(){
        return data;
    }
    
    public void setData(float[] data){
        this.data = data;
    }
    
}
