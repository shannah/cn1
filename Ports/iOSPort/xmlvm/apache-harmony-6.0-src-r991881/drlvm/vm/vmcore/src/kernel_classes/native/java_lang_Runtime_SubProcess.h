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

/**
 * @author Serguei S.Zapreyev
 * 
 * This java_lang_Runtime_SubProcess.h source ("Software") is furnished under license and may
 * only be used or copied in accordance with the terms of that license.
 * 
 **/ 

/*
 * THE FILE HAS BEEN AUTOGENERATED BY INTEL IJH TOOL.
 * Please be aware that all changes made to this file manually
 * will be overwritten by the tool if it runs again.
 */

#include <jni.h>


/* Header for class java.lang.Runtime$SubProcess */

#ifndef _JAVA_LANG_RUNTIME_SUBPROCESS_H
#define _JAVA_LANG_RUNTIME_SUBPROCESS_H

#ifdef __cplusplus
extern "C" {
#endif


/* Native methods */

/*
 * Method: java.lang.Runtime$SubProcess.close0(I)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_close0(JNIEnv *, jobject, 
    jint);

/*
 * Method: java.lang.Runtime$SubProcess.getState0(I)Z
 */
JNIEXPORT jboolean JNICALL
Java_java_lang_Runtime_00024SubProcess_getState0(JNIEnv *, jobject, 
    jint);

/*
 * Method: java.lang.Runtime$SubProcess.createProcess0([Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;[J)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_createProcess0(JNIEnv *, jobject, 
    jobjectArray, jobjectArray, jstring, jlongArray);

/*
 * Method: java.lang.Runtime$SubProcess.destroy0(I)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_destroy0(JNIEnv *, jobject, 
    jint);


#ifdef __cplusplus
}
#endif

#endif /* _JAVA_LANG_RUNTIME_SUBPROCESS_H */

