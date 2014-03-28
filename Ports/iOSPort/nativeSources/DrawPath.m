//
//  DrawPath.m
//  HelloWorldCN1
//
//  Created by Steve Hannah on 3/28/2014.
//
//

#import "DrawPath.h"
#import "com_codename1_ui_geom_PathIterator.h"
#import "java_util_ArrayList.h"
#import "Renderer.h"
#import "Transformer.h"
#import "PathConsumer.h"

static BOOL pathIsDone(JAVA_OBJECT path){
    return (*(JAVA_BOOLEAN (*)(JAVA_OBJECT)) *(((java_lang_Object*)path)->tib->itableBegin)[XMLVM_ITABLE_IDX_com_codename1_ui_geom_PathIterator_isDone__])(path);
}

static int pathCurrentSegment(JAVA_OBJECT path, JAVA_OBJECT doubleBuffer){
    return (*(JAVA_INT (*)(JAVA_OBJECT, JAVA_OBJECT)) *(((java_lang_Object*)path)->tib->itableBegin)[XMLVM_ITABLE_IDX_com_codename1_ui_geom_PathIterator_currentSegment___double_1ARRAY])(path, doubleBuffer);
}

static int pathGetWindingRule(JAVA_OBJECT path){
    return (*(JAVA_INT (*)(JAVA_OBJECT)) *(((java_lang_Object*)path)->tib->itableBegin)[XMLVM_ITABLE_IDX_com_codename1_ui_geom_PathIterator_getWindingRule__])(path);
}

static void pathNext(JAVA_OBJECT path){
    (*(JAVA_VOID (*)(JAVA_OBJECT)) *(((java_lang_Object*)path)->tib->itableBegin)[XMLVM_ITABLE_IDX_com_codename1_ui_geom_PathIterator_next__])(path);
}

const static int SEG_MOVETO = 4;
const static int SEG_LINETO = 3;
const static int SEG_QUADTO = 5;
const static int SEG_CURVETO = 2;
const static int SEG_CLOSE = 1;
const static int SEG_PATH_DONE=6;

@implementation DrawPath


-(id)initWithPath:(JAVA_OBJECT)p
{
    JAVA_OBJECT pool = com_codename1_ui_geom_PathIterator_GET_pool();
    java_util_ArrayList_add___java_lang_Object(pool, p);
    
    path = p;
}
-(void)execute
{
    JAVA_INT windingRule = pathGetWindingRule(path);
    
    
    int width=1000;
    int height=1000;
    Renderer_setup(1, 1);
    Renderer* renderer = (Renderer*)malloc(sizeof(Renderer));
    Renderer_init(renderer);
    Renderer_reset(renderer, 0, 0, width, height, windingRule); // <-- may need to convert winding rule from java value to corresponding c value.
    
    Transformer* transformer = (Transformer*)malloc(sizeof(Transformer));
    
    PathConsumer *consumer = Transformer_init(transformer, &renderer->consumer, 1.0, 0, 0, 0, 1.0, 0);
    
    JAVA_OBJECT doubleBuffer  = XMLVMArray_createSingleDimension(__CLASS_double, 6);
    org_xmlvm_runtime_XMLVMArray * bufArr = (org_xmlvm_runtime_XMLVMArray*)doubleBuffer;
    JAVA_ARRAY_DOUBLE* data = (JAVA_ARRAY_DOUBLE*)bufArr->fields.org_xmlvm_runtime_XMLVMArray.array_;
    while ( !pathIsDone(path) )
    {
        int nextSegment = pathCurrentSegment(path, doubleBuffer);
        
        switch ( nextSegment ){
            case SEG_MOVETO:
                consumer->moveTo(consumer, data[0], data[1]);
                break;
            case SEG_LINETO:
                consumer->lineTo(consumer, data[0], data[1]);
                break;
            case SEG_QUADTO:
                consumer->quadTo(consumer, data[0], data[1], data[2], data[3]);
                break;
            case SEG_CURVETO:
                consumer->curveTo(consumer, data[0], data[1], data[2], data[3], data[4], data[5]);
                break;
            case SEG_CLOSE:
                consumer->closePath(consumer);
                break;
        }
        
        pathNext(path);
    }
    consumer->pathDone(consumer);
    
    jint outputBounds[4];
    
    Renderer_getOutputBounds(renderer, (jint*)&outputBounds);
    AlphaConsumer ac = {
        outputBounds[0],
        outputBounds[1],
        outputBounds[2] - outputBounds[0],
        outputBounds[3] - outputBounds[1],
    };
    
    jbyte maskArray[ac.width*ac.height];
    NSLog(
          @"Mask width %d height %d",
          ac.width,
          ac.height
          );
    ac.alphas = (jbyte*)&maskArray;
    Renderer_produceAlphas(renderer, &ac);
    
    
    
    
}
-(void)dealloc
{
    JAVA_OBJECT pool = com_codename1_ui_geom_PathIterator_GET_pool();
    java_util_ArrayList_remove___java_lang_Object(pool, path);
    [super dealloc];
    
}
@end
