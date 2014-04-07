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
public interface Shape {
    public PathIterator getPathIterator();
    public Rectangle getBounds();
}
