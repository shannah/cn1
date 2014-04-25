//
//  DrawTextureAlphaMask.m
//  HelloWorldCN1
//
//  Created by Steve Hannah on 2014-04-25.
//
//
#import "CN1ES2compat.h"
#import "DrawTextureAlphaMask.h"

@implementation DrawTextureAlphaMask

-(id)initWithArgs:(GLuint)pTextName color:(int)pColor alpha:(int)pAlpha x:(int)pX y:(int)pY w:(int)pW h:(int)pH
{
    textureName = pTextName;
    color = pColor;
    alpha = pAlpha;
    x = pX;
    y = pY;
    w = pW;
    h = pH;
    return self;
}
-(void)execute
{
    
    if ( textureName == 0 ){
        NSLog(@"Attempt to draw null texture.  Skipping");
    }
    
    GlColorFromRGB(color, alpha);
    GLErrorLog;
    
    static const GLshort textureCoordinates[] = {
        0, 0,
        1, 0,
        0, 1,
        1, 1,
    };
    
    //NSLog(@"Drawing mask %d %d %d %d", x,y,w,h);
    GLfloat vertexes[] = {
        (GLfloat)x, (GLfloat)y,
        (GLfloat)(x+w), (GLfloat)y,
        (GLfloat)x, (GLfloat)(y+h),
        (GLfloat)(x+w), (GLfloat)(y+h)
    };
    
    glActiveTexture(GL_TEXTURE1);
    GLErrorLog;
    glBindTexture(GL_TEXTURE_2D, textureName);
    GLErrorLog;
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    GLErrorLog;
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    GLErrorLog;
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    GLErrorLog;
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    GLErrorLog;
    
    glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
    GLErrorLog;

    
    _glEnableClientState(GL_VERTEX_ARRAY);
    GLErrorLog;
    //_glEnableClientState(GL_TEXTURE_COORD_ARRAY);
    _glEnableCN1State(CN1_GL_ALPHA_TEXTURE);
    GLErrorLog;
    //_glTexCoordPointer(2, GL_SHORT, 0, textureCoordinates);
    _glAlphaMaskTexCoordPointer(2, GL_SHORT, 0, textureCoordinates);
    GLErrorLog;
    _glVertexPointer(2, GL_FLOAT, 0, vertexes);
    GLErrorLog;
    _glDrawArrays(GL_TRIANGLE_STRIP, 0, 4);
    GLErrorLog;
    _glDisableClientState(GL_VERTEX_ARRAY);
    GLErrorLog;
    //_glDisableClientState(GL_TEXTURE_COORD_ARRAY);
    _glDisableCN1State(CN1_GL_ALPHA_TEXTURE);
    GLErrorLog;
    glBindTexture(GL_TEXTURE_2D, 0);
    GLErrorLog;
    //_glDisable(GL_TEXTURE_2D);
    GLErrorLog;
}
@end
