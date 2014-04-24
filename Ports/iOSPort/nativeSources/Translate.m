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
#import "Translate.h"
#ifdef USE_ES2
#import <GLKit/GLKit.h>
#endif

// The translation (updated immediately after setting it)
int currentTranslationX=0;
int currentTranslationY=0;

// The effective translation (updated when pipeline hits it).
int effectiveTranslationX=0;
int effectiveTranslationY=0;

@implementation Translate

-(id)initWithArgs:(int)xx y:(int)yy
{
    x = xx;
    y = yy;
    return self;
}

-(void)execute
{
    effectiveTranslationY += y;
    effectiveTranslationX += x;
#ifdef USE_ES2
    GLKMatrix4 t = GLKMatrix4MakeTranslation((float)x, (float)y);
    GLKMatrix4 tp = glGetTransformES2();
    glSetTransformES2(GLKMatrix4Multiply(tp, t));
#endif
}

-(void)dealloc
{
    [super dealloc];
}
@end
