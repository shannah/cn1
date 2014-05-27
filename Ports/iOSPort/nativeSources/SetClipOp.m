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

#import "SetClipOp.h"
#ifdef USE_ES2
#import <OpenGLES/ES2/gl.h>
#endif

static int CLIP_OP_REPLACE=0;
static int CLIP_OP_INCREMENT=1;
static int CLIP_OP_DECREMENT=2;

@implementation SetClipOp
-(id)initWithArgs:(int)opP
{
    op = opP;
    return self;
}

-(void)execute
{
#ifdef USE_ES2
    GLuint glop = GL_REPLACE;
    
    switch (op){
        case CLIP_OP_REPLACE:
            glop = GL_REPLACE;
            break;
        case CLIP_OP_INCREMENT:
            glop = GL_INCR;
            break;
        case CLIP_OP_DECREMENT:
            glop = GL_DECR;
            break;
        default:
            NSLog(@"Invalid clip op %d", op);
            return;
            
    }
    
    glStencilOp(glop, GL_KEEP, GL_KEEP);
    
#endif
}

@end
