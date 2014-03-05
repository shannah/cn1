#ifndef __ORG_XMLVM_IPHONE_UITABBARCONTROLLER__
#define __ORG_XMLVM_IPHONE_UITABBARCONTROLLER__

#include "xmlvm.h"

// Preprocessor constants for interfaces:
// Implemented interfaces:
// Super Class:
#include "org_xmlvm_iphone_UIViewController.h"

// Circular references:
#ifndef XMLVM_FORWARD_DECL_java_util_ArrayList
#define XMLVM_FORWARD_DECL_java_util_ArrayList
XMLVM_FORWARD_DECL(java_util_ArrayList)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGRect
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_CGRect
XMLVM_FORWARD_DECL(org_xmlvm_iphone_CGRect)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UINavigationController
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UINavigationController
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UINavigationController)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UITabBar
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UITabBar
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UITabBar)
#endif
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UITabBarControllerDelegate
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UITabBarControllerDelegate
XMLVM_FORWARD_DECL(org_xmlvm_iphone_UITabBarControllerDelegate)
#endif
// Class declarations for org.xmlvm.iphone.UITabBarController
XMLVM_DEFINE_CLASS(org_xmlvm_iphone_UITabBarController, 12, XMLVM_ITABLE_SIZE_org_xmlvm_iphone_UITabBarController)

extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UITabBarController;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UITabBarController_1ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UITabBarController_2ARRAY;
extern JAVA_OBJECT __CLASS_org_xmlvm_iphone_UITabBarController_3ARRAY;
//XMLVM_BEGIN_DECLARATIONS
#define __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UITabBarController \
  JAVA_OBJECT viewControllers;

void org_xmlvm_iphone_UITabBarController_INTERNAL_CONSTRUCTOR(JAVA_OBJECT me, NSObject* wrappedCObj);

//XMLVM_END_DECLARATIONS

#define __INSTANCE_FIELDS_org_xmlvm_iphone_UITabBarController \
    __INSTANCE_FIELDS_org_xmlvm_iphone_UIViewController; \
    struct { \
        __ADDITIONAL_INSTANCE_FIELDS_org_xmlvm_iphone_UITabBarController \
    } org_xmlvm_iphone_UITabBarController

struct org_xmlvm_iphone_UITabBarController {
    __TIB_DEFINITION_org_xmlvm_iphone_UITabBarController* tib;
    struct {
        __INSTANCE_FIELDS_org_xmlvm_iphone_UITabBarController;
    } fields;
};
#ifndef XMLVM_FORWARD_DECL_org_xmlvm_iphone_UITabBarController
#define XMLVM_FORWARD_DECL_org_xmlvm_iphone_UITabBarController
typedef struct org_xmlvm_iphone_UITabBarController org_xmlvm_iphone_UITabBarController;
#endif

#define XMLVM_VTABLE_SIZE_org_xmlvm_iphone_UITabBarController 12
#define XMLVM_VTABLE_IDX_org_xmlvm_iphone_UITabBarController_requestInternalFrame__ 10
#define XMLVM_VTABLE_IDX_org_xmlvm_iphone_UITabBarController_updateViews__ 11

void __INIT_org_xmlvm_iphone_UITabBarController();
void __INIT_IMPL_org_xmlvm_iphone_UITabBarController();
void __DELETE_org_xmlvm_iphone_UITabBarController(void* me, void* client_data);
void __INIT_INSTANCE_MEMBERS_org_xmlvm_iphone_UITabBarController(JAVA_OBJECT me, int derivedClassWillRegisterFinalizer);
JAVA_OBJECT __NEW_org_xmlvm_iphone_UITabBarController();
JAVA_OBJECT __NEW_INSTANCE_org_xmlvm_iphone_UITabBarController();
void org_xmlvm_iphone_UITabBarController___INIT___(JAVA_OBJECT me);
// Vtable index: 10
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_requestInternalFrame__(JAVA_OBJECT me);
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_getCustomizableViewControllers__(JAVA_OBJECT me);
void org_xmlvm_iphone_UITabBarController_setCustomizableViewControllers___java_util_ArrayList(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_getDelegate__(JAVA_OBJECT me);
void org_xmlvm_iphone_UITabBarController_setDelegate___org_xmlvm_iphone_UITabBarControllerDelegate(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_getMoreNavigationController__(JAVA_OBJECT me);
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_getSelectedViewController__(JAVA_OBJECT me);
void org_xmlvm_iphone_UITabBarController_setSelectedViewController___org_xmlvm_iphone_UIViewController(JAVA_OBJECT me, JAVA_OBJECT n1);
JAVA_INT org_xmlvm_iphone_UITabBarController_getSelectedIndex__(JAVA_OBJECT me);
void org_xmlvm_iphone_UITabBarController_setSelectedIndex___int(JAVA_OBJECT me, JAVA_INT n1);
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_getTabBar__(JAVA_OBJECT me);
JAVA_OBJECT org_xmlvm_iphone_UITabBarController_getViewControllers__(JAVA_OBJECT me);
void org_xmlvm_iphone_UITabBarController_setViewControllers___java_util_ArrayList(JAVA_OBJECT me, JAVA_OBJECT n1);
void org_xmlvm_iphone_UITabBarController_setViewControllers___java_util_ArrayList_boolean(JAVA_OBJECT me, JAVA_OBJECT n1, JAVA_BOOLEAN n2);
// Vtable index: 11
void org_xmlvm_iphone_UITabBarController_updateViews__(JAVA_OBJECT me);

#endif
