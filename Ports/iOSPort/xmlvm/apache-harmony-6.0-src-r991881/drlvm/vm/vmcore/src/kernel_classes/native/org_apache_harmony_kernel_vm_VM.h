/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/*
 * THE FILE HAS BEEN AUTOGENERATED BY INTEL IJH TOOL.
 * Please be aware that all changes made to this file manually
 * will be overwritten by the tool if it runs again.
 */

#include <jni.h>


/* Header for class org.apache.harmony.kernel.vm.VM */

#ifndef _ORG_APACHE_HARMONY_KERNEL_VM_VM_H
#define _ORG_APACHE_HARMONY_KERNEL_VM_VM_H

#ifdef __cplusplus
extern "C" {
#endif


/* Native methods */

/*
 * Method: org.apache.harmony.kernel.vm.VM.getClassLoader(Ljava/lang/Class;)Ljava/lang/ClassLoader;
 */
JNIEXPORT jobject JNICALL
Java_org_apache_harmony_kernel_vm_VM_getClassLoader(JNIEnv *, jclass, 
    jclass);

/*
 * Method: org.apache.harmony.kernel.vm.VM.intern0()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL
Java_org_apache_harmony_kernel_vm_VM_intern0(JNIEnv *, jclass, jstring);


#ifdef __cplusplus
}
#endif

#endif /* _ORG_APACHE_HARMONY_KERNEL_VM_VM_H */

