//
//  DrawTextureAlphaMask.h
//  HelloWorldCN1
//
//  Created by Steve Hannah on 2014-04-25.
//
//

#import "ExecutableOp.h"
#ifdef USE_ES2
#import <OpenGLES/ES2/gl.h>
#else
#import <OpenGLES/ES1/gl.h>
#endif

@interface DrawTextureAlphaMask : ExecutableOp {
    GLuint textureName;
    int color;
    int alpha;
    int x;
    int y;
    int w;
    int h;
}

-(id)initWithArgs:(GLuint)pTextName color:(int)pColor alpha:(int)pAlpha x:(int)pX y:(int)pY w:(int)pW h:(int)pH;
-(void)execute;

@end
