//
//  Translate.h
//  HelloWorldCN1
//
//  Created by Steve Hannah on 2014-04-22.
//
//



#import "ExecutableOp.h"

@interface Translate : ExecutableOp {
    int x;
    int y;
}
-(id)initWithArgs:(int)x y:(int)y;
-(void)execute;
@end
