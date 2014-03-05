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
package com.codename1.demos.kitchen;

import com.codename1.components.MediaPlayer;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Shai Almog
 */
public class Video  extends Demo {

    public String getDisplayName() {
        return "Video";
    }

    public Image getDemoIcon() {
        return getResources().getImage("avidemux.png");
    }

    public Container createDemo() {
        Container player = new Container(new BorderLayout());
        final MediaPlayer mp = new MediaPlayer();
        try {
            
            InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/video.mp4");
            if(is != null) {
                mp.setDataSource(is, "video/mp4", null);
            } else {
                mp.setDataSource("https://dl.dropbox.com/u/57067724/cn1/video.mp4");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        player.addComponent(BorderLayout.CENTER, mp);
        return player;
    }
    
}
