#import "SetTransform.h"
#ifdef USE_ES2

#import "CodenameOne_GLViewController.h"


@implementation SetTransform

-(id)initWithArgs:(GLKMatrix4)matrix
{
    m = matrix;
    return self;
    
}

-(void)execute
{
    glSetTransformES2(m);
}

@end
#endif