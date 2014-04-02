//
//  DrawPath.h
//  HelloWorldCN1
//
//  Created by Steve Hannah on 3/28/2014.
//
//
#import <Foundation/Foundation.h>
#import "ExecutableOp.h"
#import "Renderer.h"

@interface DrawPath : ExecutableOp {
    Renderer* renderer;
    int color;
    int alpha;
}

-(id)initWithRenderer:(Renderer*)renderer color:(int)c alpha:(int)a;
-(void)execute;

@end
