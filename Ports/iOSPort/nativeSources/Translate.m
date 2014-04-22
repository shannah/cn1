//
//  Translate.m
//  HelloWorldCN1
//
//  Created by Steve Hannah on 2014-04-22.
//
//

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
