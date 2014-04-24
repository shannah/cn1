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
