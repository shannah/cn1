#import "SetTransform.h"
#ifdef USE_ES2
#import <GLKit/GLKit.h>
#import "CodenameOne_GLViewController.h"


@implementation SetTransform

-(id)initWithArgs:(GLKMatrix4)matrix originX:(int)xx originY:(int)yy
{
    m = GLKMatrix4MakeTranslation(xx, yy, 0);
    m = GLKMatrix4Multiply(m, matrix);
    m = GLKMatrix4Translate(m, -xx, -yy, 0);
    
    
    //m = GLKMatrix4Translate(matrix, xx, yy, 0);
    return self; 
}

-(void)execute
{
    glSetTransformES2(m);
                      
}

@end
#endif
