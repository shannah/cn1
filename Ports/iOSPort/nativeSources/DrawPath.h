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
    int boundsX;
    int boundsY;
    int boundsW;
    int boundsH;
}

-(id)initWithArgs:(Renderer*)renderer color:(int)c alpha:(int)a x:(int)xx y:(int)yy w:(int)ww h:(int)hh;
-(void)execute;

@end
