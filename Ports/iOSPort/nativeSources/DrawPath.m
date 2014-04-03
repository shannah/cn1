//
//  DrawPath.m
//  HelloWorldCN1
//
//  Created by Steve Hannah on 3/28/2014.
//
//
#import "xmlvm.h"
#import "CN1ES2compat.h"
#import "DrawPath.h"
#import "CodenameOne_GLViewController.h"
#import "Renderer.h"
#import "Transformer.h"
#import "PathConsumer.h"
#import "AlphaConsumer.h"
#define min(a,b) ((a)<(b)?(a):(b))
#define max(a,b) ((a)>(b)?(a):(b))
#define abs(x) ((x)>0?(x):-(x))

@implementation DrawPath


-(id)initWithRenderer:(Renderer*)r color:(int)c alpha:(int)a
{
    color = c;
    alpha = a;
    renderer = r;
    return self;
}
-(void)execute
{
    
    NSLog(@"In drawPath::execute()");
    //return;
    //_glEnableCN1State(CN1_GL_ALPHA_TEXTURE);
    
    JAVA_INT outputBounds[4];
    
    Renderer_getOutputBounds(renderer, (JAVA_INT*)&outputBounds);
    JAVA_INT x = min(outputBounds[0], outputBounds[2]);
    JAVA_INT y = min(outputBounds[1], outputBounds[3]);
    JAVA_INT width = outputBounds[2]-outputBounds[0];
    JAVA_INT height = outputBounds[3]-outputBounds[1];
    
    if ( width < 0 ) width = -width;
    if ( height < 0 ) height = -height;
    

    
    GlColorFromRGB(color, alpha);
   
    GLfloat vertexes[] = {
        x, y,
        x + width, y,
        x, y + height,
        x + width, y + height
    };
    static const GLshort textureCoordinates[] = {
        0, 0,
        1, 0,
        0, 1,
        1, 1,
    };
    
    //if ( width < 0 ) width = -width;
    //if ( height <0 ) height = -height;

   
    AlphaConsumer ac = {
        x,
        y,
        width,
        height,
    };
    
    NSLog(@"AC Width %d", ac.width);
    
    jbyte maskArray[ac.width*ac.height];
    
    NSLog(@"Mask width %d height %d",
          ac.width,
          ac.height
          );
    ac.alphas = (JAVA_BYTE*)&maskArray;
    Renderer_produceAlphas(renderer, &ac);
    
    GLuint tex;
    glGenTextures(1, &tex);
    glActiveTexture(GL_TEXTURE1);
    glBindTexture(GL_TEXTURE_2D, tex);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    
    glPixelStorei(GL_UNPACK_ALIGNMENT, 1);
    
    glTexImage2D(GL_TEXTURE_2D, 0, GL_ALPHA, ac.width, ac.height, 0, GL_ALPHA, GL_UNSIGNED_BYTE, maskArray);
    
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
-(void)dealloc
{
    [super dealloc];
    
}
@end
