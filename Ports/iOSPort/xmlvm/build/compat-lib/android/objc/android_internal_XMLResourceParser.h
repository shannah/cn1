#import "xmlvm.h"
#import "org_xmlvm_iphone_NSXMLParserDelegate.h"

// For circular include:
@class java_util_ArrayList;
@class java_lang_StringBuffer;
@class java_lang_Object;
@class java_util_Map;
@class java_lang_StringBuilder;
@class java_lang_String;
@class java_lang_Integer;
@class java_lang_Float;
@class android_view_Display;
@class org_xmlvm_iphone_NSXMLParser;
@class android_internal_ResourceAttributes;
@class java_util_Iterator;
@class org_xmlvm_iphone_NSXMLParserDelegate;
@class android_content_Context;
@class android_util_AttributeSet;
@class android_util_DisplayMetrics;
@class android_internal_Dimension;
@class android_internal_XMLResourceParser;

// Automatically generated by xmlvm2obj. Do not edit!


	
@interface android_internal_XMLResourceParser : org_xmlvm_iphone_NSXMLParserDelegate
{
@public android_content_Context* context_android_content_Context;
@public java_lang_String* prefix_java_lang_String;
@public java_util_Map* nameToIdMap_java_util_Map;
@public java_util_Map* resourceMap_java_util_Map;
@public java_lang_Integer* currentId_java_lang_Integer;
@public java_lang_StringBuffer* currentCDATA_java_lang_StringBuffer;
@public java_util_ArrayList* currentStringArrayValue_java_util_ArrayList;
@public android_util_DisplayMetrics* metrics_android_util_DisplayMetrics;

}
+ (void) initialize;
- (id) init;
- (void) __init_android_internal_XMLResourceParser___android_content_Context_java_util_Map_java_util_Map :(android_content_Context*)n1 :(java_util_Map*)n2 :(java_util_Map*)n3;
- (void) didStartMappingPrefix___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3;
- (void) didStartElement___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String_java_lang_String_java_util_Map :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3 :(java_lang_String*)n4 :(java_util_Map*)n5;
- (void) didEndElement___org_xmlvm_iphone_NSXMLParser_java_lang_String_java_lang_String_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2 :(java_lang_String*)n3 :(java_lang_String*)n4;
- (void) foundCharacters___org_xmlvm_iphone_NSXMLParser_java_lang_String :(org_xmlvm_iphone_NSXMLParser*)n1 :(java_lang_String*)n2;

@end

