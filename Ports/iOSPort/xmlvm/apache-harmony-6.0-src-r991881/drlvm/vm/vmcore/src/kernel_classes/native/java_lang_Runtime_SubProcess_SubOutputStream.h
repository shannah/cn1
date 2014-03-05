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
 * This java_lang_Runtime_SubProcess_SubOutputStream.h source ("Software") is furnished under license and may
 * only be used or copied in accordance with the terms of that license.
 * 
 **/ 

/*
 * THE FILE HAS BEEN AUTOGENERATED BY INTEL IJH TOOL.
 * Please be aware that all changes made to this file manually
 * will be overwritten by the tool if it runs again.
 */

#include <jni.h>


/* Header for class java.lang.Runtime$SubProcess$SubOutputStream */

#ifndef _JAVA_LANG_RUNTIME_SUBPROCESS_SUBOUTPUTSTREAM_H
#define _JAVA_LANG_RUNTIME_SUBPROCESS_SUBOUTPUTSTREAM_H

#ifdef __cplusplus
extern "C" {
#endif


/* Native methods */

/*
 * Method: java.lang.Runtime$SubProcess$SubOutputStream.writeOutputByte0(JI)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_00024SubOutputStream_writeOutputByte0(JNIEnv *, jobject, 
    jlong, jint);

/*
 * Method: java.lang.Runtime$SubProcess$SubOutputStream.writeOutputBytes0(J[BII)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_00024SubOutputStream_writeOutputBytes0(JNIEnv *, jobject, 
    jlong, jbyteArray, jint, jint);

/*
 * Method: java.lang.Runtime$SubProcess$SubOutputStream.flush0(J)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_00024SubOutputStream_flush0(JNIEnv *, jobject, 
    jlong);

/*
 * Method: java.lang.Runtime$SubProcess$SubOutputStream.close0(J)V
 */
JNIEXPORT void JNICALL
Java_java_lang_Runtime_00024SubProcess_00024SubOutputStream_close0(JNIEnv *, jobject, 
    jlong);


#ifdef __cplusplus
}
#endif

#endif /* _JAVA_LANG_RUNTIME_SUBPROCESS_SUBOUTPUTSTREAM_H */

