#import "SetTransform.h"
#ifdef USE_ES2
#import <GLKit/GLKit.h>
#import "CodenameOne_GLViewController.h"

static GLKMatrix4 currentTransform;
static BOOL currentTransformInitialized = NO;
@implementation SetTransform

-(id)initWithArgs:(GLKMatrix4)matrix originX:(int)xx originY:(int)yy
{
    if ( NO && (xx != 0 || yy != 0) ){
        m = GLKMatrix4MakeTranslation(xx, yy, 0);
        m = GLKMatrix4Multiply(m, matrix);
        m = GLKMatrix4Translate(m, -xx, -yy, 0);
    } else {
        m = matrix;
    }
    
    
    
    //m = GLKMatrix4Translate(matrix, xx, yy, 0);
    currentTransform = m;
    currentTransformInitialized = YES;
    return self; 
}

-(void)execute
{
    glSetTransformES2(m);
                      
}

+(GLKMatrix4)currentTransform
{
    if ( !currentTransformInitialized ){
        currentTransform = GLKMatrix4Identity;
    }
    return currentTransform;
}

+(void)currentTransform:(GLKMatrix4)matrix
{
    currentTransform = matrix;
    currentTransformInitialized = YES;
}

@end
#endif
