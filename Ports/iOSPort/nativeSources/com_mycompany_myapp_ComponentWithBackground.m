#include "xmlvm.h"
#include "com_codename1_io_Log.h"
#include "com_codename1_ui_Graphics.h"
#include "com_codename1_ui_geom_GeneralPath.h"
#include "java_lang_String.h"
#include "java_lang_StringBuilder.h"

#include "com_mycompany_myapp_ComponentWithBackground.h"

#define XMLVM_CURRENT_CLASS_NAME ComponentWithBackground
#define XMLVM_CURRENT_PKG_CLASS_NAME com_mycompany_myapp_ComponentWithBackground

__TIB_DEFINITION_com_mycompany_myapp_ComponentWithBackground __TIB_com_mycompany_myapp_ComponentWithBackground = {
    0, // classInitializationBegan
    0, // classInitialized
    -1, // initializerThreadId
    __INIT_com_mycompany_myapp_ComponentWithBackground, // classInitializer
    "com.mycompany.myapp.ComponentWithBackground", // className
    "com.mycompany.myapp", // package
    JAVA_NULL, // enclosingClassName
    JAVA_NULL, // enclosingMethodName
    JAVA_NULL, // signature
    (__TIB_DEFINITION_TEMPLATE*) &__TIB_com_codename1_ui_Component, // extends
    sizeof(com_mycompany_myapp_ComponentWithBackground), // sizeInstance
    XMLVM_TYPE_CLASS};

JAVA_OBJECT __CLASS_com_mycompany_myapp_ComponentWithBackground;
JAVA_OBJECT __CLASS_com_mycompany_myapp_ComponentWithBackground_1ARRAY;
JAVA_OBJECT __CLASS_com_mycompany_myapp_ComponentWithBackground_2ARRAY;
JAVA_OBJECT __CLASS_com_mycompany_myapp_ComponentWithBackground_3ARRAY;
//XMLVM_BEGIN_IMPLEMENTATION
//XMLVM_END_IMPLEMENTATION


#include "xmlvm-reflection.h"

static XMLVM_FIELD_REFLECTION_DATA __field_reflection_data[] = {
};

static JAVA_OBJECT* __constructor0_arg_types[] = {
};

static XMLVM_CONSTRUCTOR_REFLECTION_DATA __constructor_reflection_data[] = {
    {&__constructor0_arg_types[0],
    sizeof(__constructor0_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
};

static JAVA_OBJECT constructor_dispatcher(JAVA_OBJECT constructor, JAVA_OBJECT arguments)
{
    JAVA_OBJECT obj = __NEW_com_mycompany_myapp_ComponentWithBackground();
    java_lang_reflect_Constructor* c = (java_lang_reflect_Constructor*) constructor;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (c->fields.java_lang_reflect_Constructor.slot_) {
    case 0:
        com_mycompany_myapp_ComponentWithBackground___INIT___(obj);
        break;
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return obj;
}

static JAVA_OBJECT* __method0_arg_types[] = {
    &__CLASS_com_codename1_ui_Graphics,
};

static XMLVM_METHOD_REFLECTION_DATA __method_reflection_data[] = {
    {"paintBackground",
    &__method0_arg_types[0],
    sizeof(__method0_arg_types) / sizeof(JAVA_OBJECT*),
    JAVA_NULL,
    0,
    0,
    "",
    JAVA_NULL,
    JAVA_NULL},
};

static JAVA_OBJECT method_dispatcher(JAVA_OBJECT method, JAVA_OBJECT receiver, JAVA_OBJECT arguments)
{
    JAVA_OBJECT result = JAVA_NULL; //TODO need to set result
    java_lang_Object* obj = receiver;
    java_lang_reflect_Method* m = (java_lang_reflect_Method*) method;
    org_xmlvm_runtime_XMLVMArray* args = (org_xmlvm_runtime_XMLVMArray*) arguments;
    JAVA_ARRAY_OBJECT* argsArray = (JAVA_ARRAY_OBJECT*) args->fields.org_xmlvm_runtime_XMLVMArray.array_;
    switch (m->fields.java_lang_reflect_Method.slot_) {
    case 0:
        com_mycompany_myapp_ComponentWithBackground_paintBackground___com_codename1_ui_Graphics(receiver, argsArray[0]);
        break;
    default:
        XMLVM_INTERNAL_ERROR();
        break;
    }
    return result;
}

void __INIT_com_mycompany_myapp_ComponentWithBackground()
{
    staticInitializerLock(&__TIB_com_mycompany_myapp_ComponentWithBackground);

    // While the static initializer mutex is locked, locally store the value of
    // whether class initialization began or not
    int initBegan = __TIB_com_mycompany_myapp_ComponentWithBackground.classInitializationBegan;

    // Whether or not class initialization had already began, it has begun now
    __TIB_com_mycompany_myapp_ComponentWithBackground.classInitializationBegan = 1;

    staticInitializerUnlock(&__TIB_com_mycompany_myapp_ComponentWithBackground);

    JAVA_LONG curThreadId = (JAVA_LONG)pthread_self();
    if (initBegan) {
        if (__TIB_com_mycompany_myapp_ComponentWithBackground.initializerThreadId != curThreadId) {
            // Busy wait until the other thread finishes initializing this class
            while (!__TIB_com_mycompany_myapp_ComponentWithBackground.classInitialized) {
                // do nothing
            }
        }
    } else {
        __TIB_com_mycompany_myapp_ComponentWithBackground.initializerThreadId = curThreadId;
        __INIT_IMPL_com_mycompany_myapp_ComponentWithBackground();
    }
}

void __INIT_IMPL_com_mycompany_myapp_ComponentWithBackground()
{
    // Initialize base class if necessary
    if (!__TIB_com_codename1_ui_Component.classInitialized) __INIT_com_codename1_ui_Component();
    __TIB_com_mycompany_myapp_ComponentWithBackground.newInstanceFunc = __NEW_INSTANCE_com_mycompany_myapp_ComponentWithBackground;
    // Copy vtable from base class
    XMLVM_MEMCPY(__TIB_com_mycompany_myapp_ComponentWithBackground.vtable, __TIB_com_codename1_ui_Component.vtable, sizeof(__TIB_com_codename1_ui_Component.vtable));
    // Initialize vtable for this class
    __TIB_com_mycompany_myapp_ComponentWithBackground.vtable[162] = (VTABLE_PTR) &com_mycompany_myapp_ComponentWithBackground_paintBackground___com_codename1_ui_Graphics;
    // Initialize interface information
    __TIB_com_mycompany_myapp_ComponentWithBackground.numImplementedInterfaces = 2;
    __TIB_com_mycompany_myapp_ComponentWithBackground.implementedInterfaces = (__TIB_DEFINITION_TEMPLATE* (*)[1]) XMLVM_MALLOC(sizeof(__TIB_DEFINITION_TEMPLATE*) * 2);

    // Initialize interfaces if necessary and assign tib to implementedInterfaces

    if (!__TIB_com_codename1_ui_animations_Animation.classInitialized) __INIT_com_codename1_ui_animations_Animation();
    __TIB_com_mycompany_myapp_ComponentWithBackground.implementedInterfaces[0][0] = &__TIB_com_codename1_ui_animations_Animation;

    if (!__TIB_com_codename1_ui_events_StyleListener.classInitialized) __INIT_com_codename1_ui_events_StyleListener();
    __TIB_com_mycompany_myapp_ComponentWithBackground.implementedInterfaces[0][1] = &__TIB_com_codename1_ui_events_StyleListener;
    // Initialize itable for this class
    __TIB_com_mycompany_myapp_ComponentWithBackground.itableBegin = &__TIB_com_mycompany_myapp_ComponentWithBackground.itable[0];
    __TIB_com_mycompany_myapp_ComponentWithBackground.itable[XMLVM_ITABLE_IDX_com_codename1_ui_animations_Animation_animate__] = __TIB_com_mycompany_myapp_ComponentWithBackground.vtable[16];
    __TIB_com_mycompany_myapp_ComponentWithBackground.itable[XMLVM_ITABLE_IDX_com_codename1_ui_animations_Animation_paint___com_codename1_ui_Graphics] = __TIB_com_mycompany_myapp_ComponentWithBackground.vtable[176];
    __TIB_com_mycompany_myapp_ComponentWithBackground.itable[XMLVM_ITABLE_IDX_com_codename1_ui_events_StyleListener_styleChanged___java_lang_String_com_codename1_ui_plaf_Style] = __TIB_com_mycompany_myapp_ComponentWithBackground.vtable[267];


    __TIB_com_mycompany_myapp_ComponentWithBackground.declaredFields = &__field_reflection_data[0];
    __TIB_com_mycompany_myapp_ComponentWithBackground.numDeclaredFields = sizeof(__field_reflection_data) / sizeof(XMLVM_FIELD_REFLECTION_DATA);
    __TIB_com_mycompany_myapp_ComponentWithBackground.constructorDispatcherFunc = constructor_dispatcher;
    __TIB_com_mycompany_myapp_ComponentWithBackground.declaredConstructors = &__constructor_reflection_data[0];
    __TIB_com_mycompany_myapp_ComponentWithBackground.numDeclaredConstructors = sizeof(__constructor_reflection_data) / sizeof(XMLVM_CONSTRUCTOR_REFLECTION_DATA);
    __TIB_com_mycompany_myapp_ComponentWithBackground.methodDispatcherFunc = method_dispatcher;
    __TIB_com_mycompany_myapp_ComponentWithBackground.declaredMethods = &__method_reflection_data[0];
    __TIB_com_mycompany_myapp_ComponentWithBackground.numDeclaredMethods = sizeof(__method_reflection_data) / sizeof(XMLVM_METHOD_REFLECTION_DATA);
    __CLASS_com_mycompany_myapp_ComponentWithBackground = XMLVM_CREATE_CLASS_OBJECT(&__TIB_com_mycompany_myapp_ComponentWithBackground);
    __TIB_com_mycompany_myapp_ComponentWithBackground.clazz = __CLASS_com_mycompany_myapp_ComponentWithBackground;
    __TIB_com_mycompany_myapp_ComponentWithBackground.baseType = JAVA_NULL;
    __CLASS_com_mycompany_myapp_ComponentWithBackground_1ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_com_mycompany_myapp_ComponentWithBackground);
    __CLASS_com_mycompany_myapp_ComponentWithBackground_2ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_com_mycompany_myapp_ComponentWithBackground_1ARRAY);
    __CLASS_com_mycompany_myapp_ComponentWithBackground_3ARRAY = XMLVM_CREATE_ARRAY_CLASS_OBJECT(__CLASS_com_mycompany_myapp_ComponentWithBackground_2ARRAY);
    //XMLVM_BEGIN_WRAPPER[__INIT_com_mycompany_myapp_ComponentWithBackground]
    //XMLVM_END_WRAPPER

    __TIB_com_mycompany_myapp_ComponentWithBackground.classInitialized = 1;
}

void __DELETE_com_mycompany_myapp_ComponentWithBackground(void* me, void* client_data)
{
    //XMLVM_BEGIN_WRAPPER[__DELETE_com_mycompany_myapp_ComponentWithBackground]
    //XMLVM_END_WRAPPER
}

void __INIT_INSTANCE_MEMBERS_com_mycompany_myapp_ComponentWithBackground(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer)
{
    __INIT_INSTANCE_MEMBERS_com_codename1_ui_Component(me, 0 || derivedClassWillRegisterFinalizer);
    //XMLVM_BEGIN_WRAPPER[__INIT_INSTANCE_MEMBERS_com_mycompany_myapp_ComponentWithBackground]
    //XMLVM_END_WRAPPER
}

JAVA_OBJECT __NEW_com_mycompany_myapp_ComponentWithBackground()
{
    if (!__TIB_com_mycompany_myapp_ComponentWithBackground.classInitialized) __INIT_com_mycompany_myapp_ComponentWithBackground();
    com_mycompany_myapp_ComponentWithBackground* me = (com_mycompany_myapp_ComponentWithBackground*) XMLVM_MALLOC(sizeof(com_mycompany_myapp_ComponentWithBackground));
    me->tib = &__TIB_com_mycompany_myapp_ComponentWithBackground;
    __INIT_INSTANCE_MEMBERS_com_mycompany_myapp_ComponentWithBackground(me, 0);
    //XMLVM_BEGIN_WRAPPER[__NEW_com_mycompany_myapp_ComponentWithBackground]
    //XMLVM_END_WRAPPER
    return me;
}

JAVA_OBJECT __NEW_INSTANCE_com_mycompany_myapp_ComponentWithBackground()
{
    JAVA_OBJECT me = JAVA_NULL;
    me = __NEW_com_mycompany_myapp_ComponentWithBackground();
    com_mycompany_myapp_ComponentWithBackground___INIT___(me);
    return me;
}

void com_mycompany_myapp_ComponentWithBackground___INIT___(JAVA_OBJECT me)
{
    //XMLVM_BEGIN_WRAPPER[com_mycompany_myapp_ComponentWithBackground___INIT___]
    XMLVM_ENTER_METHOD("com.mycompany.myapp.ComponentWithBackground", "<init>", "?")
    XMLVMElem _r0;
    _r0.o = me;
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 18)
    XMLVM_CHECK_NPE(0)
    com_codename1_ui_Component___INIT___(_r0.o);
    XMLVM_EXIT_METHOD()
    return;
    //XMLVM_END_WRAPPER
}

void com_mycompany_myapp_ComponentWithBackground_paintBackground___com_codename1_ui_Graphics(JAVA_OBJECT me, JAVA_OBJECT n1)
{
    //XMLVM_BEGIN_WRAPPER[com_mycompany_myapp_ComponentWithBackground_paintBackground___com_codename1_ui_Graphics]
    XMLVM_ENTER_METHOD("com.mycompany.myapp.ComponentWithBackground", "paintBackground", "?")
    XMLVMElem _r0;
    XMLVMElem _r1;
    XMLVMElem _r2;
    XMLVMElem _r3;
    XMLVMElem _r4;
    XMLVMElem _r5;
    XMLVMElem _r6;
    XMLVMElem _r7;
    XMLVMElem _r8;
    XMLVMElem _r9;
    XMLVMElem _r10;
    _r9.o = me;
    _r10.o = n1;
    _r8.i = 200;
    _r2.f = 1.1;
    _r5.f = 0.0;
    _r3.i = 0;
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 22)
    XMLVM_CHECK_NPE(9)
    com_codename1_ui_Component_paintBackground___com_codename1_ui_Graphics(_r9.o, _r10.o);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 23)
    _r0.o = __NEW_java_lang_StringBuilder();
    XMLVM_CHECK_NPE(0)
    java_lang_StringBuilder___INIT___(_r0.o);
    // "Width is "
    _r4.o = xmlvm_create_java_string_from_pool(3072);
    //java_lang_StringBuilder_append___java_lang_String[60]
    XMLVM_CHECK_NPE(0)
    _r0.o = (*(JAVA_OBJECT (*)(JAVA_OBJECT, JAVA_OBJECT)) ((java_lang_StringBuilder*) _r0.o)->tib->vtable[60])(_r0.o, _r4.o);
    //com_mycompany_myapp_ComponentWithBackground_getWidth__[109]
    XMLVM_CHECK_NPE(9)
    _r4.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[109])(_r9.o);
    //java_lang_StringBuilder_append___int[56]
    XMLVM_CHECK_NPE(0)
    _r0.o = (*(JAVA_OBJECT (*)(JAVA_OBJECT, JAVA_INT)) ((java_lang_StringBuilder*) _r0.o)->tib->vtable[56])(_r0.o, _r4.i);
    //java_lang_StringBuilder_toString__[8]
    XMLVM_CHECK_NPE(0)
    _r0.o = (*(JAVA_OBJECT (*)(JAVA_OBJECT)) ((java_lang_StringBuilder*) _r0.o)->tib->vtable[8])(_r0.o);
    com_codename1_io_Log_p___java_lang_String(_r0.o);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 24)
    _r0.i = 16776960;
    //com_codename1_ui_Graphics_setColor___int[75]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_INT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[75])(_r10.o, _r0.i);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 25)
    //com_mycompany_myapp_ComponentWithBackground_getX__[110]
    XMLVM_CHECK_NPE(9)
    _r0.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[110])(_r9.o);
    //com_mycompany_myapp_ComponentWithBackground_getY__[111]
    XMLVM_CHECK_NPE(9)
    _r4.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[111])(_r9.o);
    //com_mycompany_myapp_ComponentWithBackground_getWidth__[109]
    XMLVM_CHECK_NPE(9)
    _r6.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[109])(_r9.o);
    //com_mycompany_myapp_ComponentWithBackground_getHeight__[71]
    XMLVM_CHECK_NPE(9)
    _r7.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[71])(_r9.o);
    //com_codename1_ui_Graphics_fillRect___int_int_int_int[40]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_INT, JAVA_INT, JAVA_INT, JAVA_INT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[40])(_r10.o, _r0.i, _r4.i, _r6.i, _r7.i);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 28)
    _r0.i = 16711680;
    //com_codename1_ui_Graphics_setColor___int[75]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_INT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[75])(_r10.o, _r0.i);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 29)
    _r1.o = __NEW_com_codename1_ui_geom_GeneralPath();
    XMLVM_CHECK_NPE(1)
    com_codename1_ui_geom_GeneralPath___INIT___(_r1.o);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 30)
    //com_mycompany_myapp_ComponentWithBackground_getX__[110]
    XMLVM_CHECK_NPE(9)
    _r0.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[110])(_r9.o);
    _r0.f = (JAVA_FLOAT) _r0.i;
    //com_mycompany_myapp_ComponentWithBackground_getY__[111]
    XMLVM_CHECK_NPE(9)
    _r4.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[111])(_r9.o);
    _r4.f = (JAVA_FLOAT) _r4.i;
    //com_codename1_ui_geom_GeneralPath_moveTo___float_float[23]
    XMLVM_CHECK_NPE(1)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT, JAVA_FLOAT)) ((com_codename1_ui_geom_GeneralPath*) _r1.o)->tib->vtable[23])(_r1.o, _r0.f, _r4.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 31)
    //com_mycompany_myapp_ComponentWithBackground_getWidth__[109]
    XMLVM_CHECK_NPE(9)
    _r0.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[109])(_r9.o);
    _r0.i = _r0.i / 2;
    _r0.f = (JAVA_FLOAT) _r0.i;
    //com_mycompany_myapp_ComponentWithBackground_getHeight__[71]
    XMLVM_CHECK_NPE(9)
    _r4.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[71])(_r9.o);
    _r4.i = _r4.i / 2;
    _r4.f = (JAVA_FLOAT) _r4.i;
    //com_codename1_ui_geom_GeneralPath_lineTo___float_float[22]
    XMLVM_CHECK_NPE(1)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT, JAVA_FLOAT)) ((com_codename1_ui_geom_GeneralPath*) _r1.o)->tib->vtable[22])(_r1.o, _r0.f, _r4.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 32)
    //com_mycompany_myapp_ComponentWithBackground_getX__[110]
    XMLVM_CHECK_NPE(9)
    _r0.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[110])(_r9.o);
    _r0.f = (JAVA_FLOAT) _r0.i;
    //com_mycompany_myapp_ComponentWithBackground_getHeight__[71]
    XMLVM_CHECK_NPE(9)
    _r4.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[71])(_r9.o);
    _r4.i = _r4.i / 2;
    _r4.f = (JAVA_FLOAT) _r4.i;
    //com_codename1_ui_geom_GeneralPath_lineTo___float_float[22]
    XMLVM_CHECK_NPE(1)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT, JAVA_FLOAT)) ((com_codename1_ui_geom_GeneralPath*) _r1.o)->tib->vtable[22])(_r1.o, _r0.f, _r4.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 33)
    //com_mycompany_myapp_ComponentWithBackground_getWidth__[109]
    XMLVM_CHECK_NPE(9)
    _r0.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[109])(_r9.o);
    _r0.i = _r0.i / 4;
    _r0.f = (JAVA_FLOAT) _r0.i;
    //com_mycompany_myapp_ComponentWithBackground_getHeight__[71]
    XMLVM_CHECK_NPE(9)
    _r4.i = (*(JAVA_INT (*)(JAVA_OBJECT)) ((com_mycompany_myapp_ComponentWithBackground*) _r9.o)->tib->vtable[71])(_r9.o);
    _r4.i = _r4.i / 8;
    _r4.f = (JAVA_FLOAT) _r4.i;
    //com_codename1_ui_geom_GeneralPath_quadTo___float_float_float_float[24]
    XMLVM_CHECK_NPE(1)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT)) ((com_codename1_ui_geom_GeneralPath*) _r1.o)->tib->vtable[24])(_r1.o, _r0.f, _r4.f, _r5.f, _r5.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 34)
    //com_codename1_ui_geom_GeneralPath_closePath__[15]
    XMLVM_CHECK_NPE(1)
    (*(void (*)(JAVA_OBJECT)) ((com_codename1_ui_geom_GeneralPath*) _r1.o)->tib->vtable[15])(_r1.o);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 36)
    //com_codename1_ui_Graphics_fillShape___com_codename1_ui_geom_Shape[43]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_OBJECT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[43])(_r10.o, _r1.o);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 37)
    //com_codename1_ui_Graphics_setColor___int[75]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_INT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[75])(_r10.o, _r3.i);
    _r0 = _r10;
    _r4 = _r3;
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 38)
    //com_codename1_ui_Graphics_drawShape___com_codename1_ui_geom_Shape_float_int_int_float[30]
    XMLVM_CHECK_NPE(0)
    (*(void (*)(JAVA_OBJECT, JAVA_OBJECT, JAVA_FLOAT, JAVA_INT, JAVA_INT, JAVA_FLOAT)) ((com_codename1_ui_Graphics*) _r0.o)->tib->vtable[30])(_r0.o, _r1.o, _r2.f, _r3.i, _r4.i, _r5.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 40)
    _r0.f = 0.5;
    //com_codename1_ui_Graphics_rotate___float[67]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[67])(_r10.o, _r0.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 46)
    _r0.i = 65280;
    //com_codename1_ui_Graphics_setColor___int[75]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_INT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[75])(_r10.o, _r0.i);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 47)
    _r0.f = 1.0;
    //com_codename1_ui_Graphics_scale___float_float[69]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT, JAVA_FLOAT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[69])(_r10.o, 2.0, 1.0);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 48)
    //com_codename1_ui_Graphics_translate___int_int[81]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_INT, JAVA_INT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[81])(_r10.o, _r8.i, _r8.i);
    _r0 = _r10;
    _r4 = _r3;
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 49)
    //com_codename1_ui_Graphics_drawShape___com_codename1_ui_geom_Shape_float_int_int_float[30]
    XMLVM_CHECK_NPE(0)
    (*(void (*)(JAVA_OBJECT, JAVA_OBJECT, JAVA_FLOAT, JAVA_INT, JAVA_INT, JAVA_FLOAT)) ((com_codename1_ui_Graphics*) _r0.o)->tib->vtable[30])(_r0.o, _r1.o, _r2.f, _r3.i, _r4.i, _r5.f);
    XMLVM_SOURCE_POSITION("ComponentWithBackground.java", 61)
    //com_codename1_ui_Graphics_scale___float_float[69]
    XMLVM_CHECK_NPE(10)
    (*(void (*)(JAVA_OBJECT, JAVA_FLOAT, JAVA_FLOAT)) ((com_codename1_ui_Graphics*) _r10.o)->tib->vtable[69])(_r10.o, 0.5, 1.0);

    XMLVM_EXIT_METHOD()
    return;
    //XMLVM_END_WRAPPER
}

