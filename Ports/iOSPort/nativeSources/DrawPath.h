//
//  DrawPath.h
//  HelloWorldCN1
//
//  Created by Steve Hannah on 3/28/2014.
//
//
#import "xmlvm.h"
#import <Foundation/Foundation.h>
#import "ExecutableOp.h"

@interface DrawPath : ExecutableOp {
    JAVA_OBJECT path;
    BOOL fill;
    int color;
    int alpha;
}

-(id)initWithPath:(JAVA_OBJECT)path;
-(void)execute;

@end
