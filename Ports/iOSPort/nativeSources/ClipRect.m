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
#import "ClipRect.h"
#import "CodenameOne_GLViewController.h"
#import "FillRect.h"

static int clipX, clipY, clipW, clipH;
static BOOL clipApplied = NO;
extern float currentScaleX;
extern float currentScaleY;
extern float scaleValue;

@implementation ClipRect
static CGRect drawingRect;

-(id)initWithArgs:(int)xpos ypos:(int)ypos w:(int)w h:(int)h f:(BOOL)f {
    x = xpos;
    y = ypos;
    width = w;
    height = h;
    return self;
}

+(void)setDrawRect:(CGRect)rect {
    drawingRect = rect;
}

-(void)executeWithClipping {
    [self execute];
}

-(void)executeWithLog {
    NSDate *start = [NSDate date];
    [self executeWithClipping];
    NSDate *finish = [NSDate date];
    NSTimeInterval t = [finish timeIntervalSinceDate:start];
    NSLog(@"%@ took %f", [self getName], t);
}

-(void)execute {
#ifdef USE_ES2
    //NSLog(@"Using ES2 clipping %d %d %d %d ", x, y, width, height);
    glClearStencil(0x0);
    
    glEnable(GL_STENCIL_TEST);
    glStencilFunc(GL_NEVER, 1, 0xff);
    
    glStencilOp(GL_REPLACE, GL_KEEP, GL_KEEP);
    glColorMask(GL_FALSE, GL_FALSE, GL_FALSE, GL_FALSE);
    glStencilMask(0xff);
    glClear(GL_STENCIL_BUFFER_BIT);
    FillRect* f = [[FillRect alloc] initWithArgs:0xffffff a:0xff xpos:x ypos:y w:width h:height];
    [f execute];
    [f release];
    glColorMask(GL_TRUE, GL_TRUE, GL_TRUE, GL_TRUE);
    glStencilMask(0x0);
    glStencilFunc(GL_EQUAL, 1, 0xff);
    
    //glStencilOp(GL_KEEP, GL_KEEP, GL_KEEP);
    
    
    
#else
    int x2 = x + width;
    int y2 = y + height;
    int orX = drawingRect.origin.x;
    int orY = drawingRect.origin.y;
    if(x < orX) {
        x = orX;
    }
    if(y < orY) {
        y = orY;
    }
    int destX2 = (int)(drawingRect.origin.x + drawingRect.size.width);
    int destY2 = (int)(drawingRect.origin.y + drawingRect.size.height);
    if(x2 > destX2) {
        width = destX2 - x;
    }
    if(y2 > destY2) {
        height = destY2 - y;
    }
    if(width > 0 && height > 0) {
        [super clipBlock:NO];
        // full screen access, no need for this
        int scale = scaleValue;
        int displayHeight = [CodenameOne_GLViewController instance].view.bounds.size.height * scale;
        if(width == [CodenameOne_GLViewController instance].view.bounds.size.width * scale && height == displayHeight) {
            _glDisable(GL_SCISSOR_TEST);
            GLErrorLog;
            return;
        }
        clipX = x;
        clipY = y;
        clipW = width;
        clipH = height;
        [ClipRect updateClipToScale];
        _glEnable(GL_SCISSOR_TEST);
        GLErrorLog;
        clipApplied = YES;
    } else {
        [super clipBlock:YES];
        _glDisable(GL_SCISSOR_TEST);
        GLErrorLog;
        clipApplied = NO;
    }
#endif
}


+(void)updateClipToScale {
#ifdef USE_ES2
    //NSLog(@"Using ES2 clipping scale");
    
#else
    int displayHeight = [CodenameOne_GLViewController instance].view.bounds.size.height * scaleValue;
    if(currentScaleX == 1 && currentScaleY == 1) {
        glScissor(clipX, displayHeight - clipY - clipH, clipW, clipH);
    }
#endif
}

-(void)dealloc {
	[super dealloc];
}

-(NSString*)getName {
    return @"ClipRect";
}


@end
