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
 * Encapsulates a 4x4 transformation matrix that can be used to apply 3D transformations
 * to a {@link com.codename1.ui.Graphics} context. This can also be used for 2D transformations,
 * by only using the upper left 3x3 grid of the matrix.
 * 
 * <h4>Internal Representation</h4>
 * 
 * <p>Although matrix data can be set in several different formats (See {@link #setData}), the internal representation
 * is always that of a 4x4 matrix stored in a 16-element {@literal float} array in <a target="_blank" href="http://en.wikipedia.org/wiki/Row-major_order">row-major order</a>.
 * If you are working with 2D transformations only, then the upper left sub-matrix will contain
 * your 3x3 affine transformation, and the 4th row and 4th columns will be zeroes, except in the lower-right most
 * column, which will be a {@literal 1}.</p>
 * 
 * @author shannah
 * @see com.codename1.ui.Graphics#setTransform
 * @see com.codename1.ui.Graphics#getTransform
 */
public final class Matrix {
    private float[] data;
    
    /**
     * Constructor.  Copies data from the provided data array.  See {@link #setData}
     * documentation for information acceptable formats for the {@literal m} array.
     * @param m An array containing data for the matrix.  This can be in several different formats.  See {@link #setData}
     * for a list of acceptable formats.
     * 
     * @see #setData
     */
    public Matrix(float[] m){
        setData(m);
    }
    
    /**
     * Obtains a reference to the 4x4 matrix cell data in <a target="_blank" href="http://en.wikipedia.org/wiki/Row-major_order">row-major order</a>.
     * @return A 16-element{@literal float} array representing the 4x4 matrix data in row-major order.
     */
    public float[] getData(){
        return data;
    }
    
    /**
     * Sets the matrix data.  This will accept the data in several different formats to facilitate the creation of
     * common matrix use-cases.
     * <h5>Acceptable Formats</h5>
     * 
     * <table>
     *  <tr><th>Array Length</th><th>Interpretation</th><th>Example</th><th>Resulting 4x4 Matrix</th></tr>
     *  <tr>
     *      <td>1</td>
     *      <td>Apply both {@literal x} and {@literal y} scaling with a single value.</td>
     *      <td>{@code setData(new float[]{2f});}</td>
     *      <td><pre>{@literal 
     *  [2,0,0,0], 
     * [0,2,0,0], 
     * [0,0,1,0], 
     * [0,0,0,1]}</pre></td>
     *  </tr>
     * <tr>
     *      <td>2</td>
     *      <td>Applies {@literal x} and {@literal y} scaling.  First element is {@literal x} scale.  Second element is {@literal y} scale.</td>
     *      <td>{@code setData(new float[]{2f, 3f});}</td>
     *      <td><pre>{@literal 
     *  [2,0,0,0], 
     * [0,3,0,0], 
     * [0,0,1,0], 
     * [0,0,0,1]}</pre></td>
     *  </tr>
     * <tr>
     *      <td>4</td>
     *      <td>Recognized as a 2x2 2D transformation matrix.</td>
     *      <td>{@code setData(new float[]{1f, 2f, 3f, 4f});}</td>
     *      <td><pre>{@literal 
     *  [1,2,0,0], 
     * [3,4,0,0], 
     * [0,0,1,0], 
     * [0,0,0,1]}</pre></td>
     *  </tr>
     * <tr>
     *      <td>6</td>
     *      <td>An affine transformation.</td>
     *      <td>{@code setData(new float[]{1f, 2f, 3f, 4f, 5f, 6f});}</td>
     *      <td><pre>{@literal 
     *  [1,2,3,0], 
     * [4,5,6,0], 
     * [0,0,1,0], 
     * [0,0,0,1]}</pre></td>
     *  </tr>
     * <tr>
     *      <td>9</td>
     *      <td>A 3x3 matrix.</td>
     *      <td>{@code setData(new float[]{1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f});}</td>
     *      <td><pre>{@literal 
     *  [1,2,3,0], 
     * [4,5,6,0], 
     * [7,8,9,0], 
     * [0,0,0,1]}</pre></td>
     *  </tr>
     * <tr>
     *      <td>12</td>
     *      <td>The top 3 rows of the 4x4 matrix.  This is all the information necessary for a 3D transformation since the last row is always [0,0,0,1].</td>
     *      <td>{@code setData(new float[]{1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f});}</td>
     *      <td><pre>{@literal 
     *  [ 1, 2, 3, 4], 
     * [ 5, 6, 7, 8], 
     * [ 9, 10,11,12], 
     * [ 0, 0, 0, 1]}</pre></td>
     *  </tr>
     * <tr>
     *      <td>16</td>
     *      <td>A 4x4 transformation matrix.</td>
     *      <td>{@code setData(new float[]{1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f, 9f, 10f, 11f, 12f, 13f, 14f, 15f, 16f});}</td>
     *      <td><pre>{@literal 
     *  [ 1, 2, 3, 4], 
     * [ 5, 6, 7, 8], 
     * [ 9,10,11,12], 
     * [13,14,15,16]}</pre></td>
     *  </tr>
     * </table>
     * @param m The data to populate the matrix.  This will always replace the matrix data in full.
     */
    public void setData(float[] m){
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
    
}
