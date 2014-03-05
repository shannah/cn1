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
 * @author Dmitry B. Yershov
 */
package java.lang;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;


/**
 * @com.intel.drl.spec_ref 
 */
public class Throwable implements  Serializable {
    
    private static final long serialVersionUID = -3042686055658047285L;
    
    private Throwable cause = this ;
    
    private final String detailMessage;
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable() {
        fillInStackTrace();
        detailMessage = null;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable(String message) {
        fillInStackTrace();
        this .detailMessage = message;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable(String message, Throwable cause) {
        this (message);
        this .cause = cause;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable(Throwable cause) {
        this ((cause == null ? null : cause.toString()), cause);
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable fillInStackTrace() {
        return this ;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable getCause() {
        return cause == this  ? null : cause;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public String getLocalizedMessage() {
        return detailMessage;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public String getMessage() {
        return detailMessage;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public StackTraceElement[] getStackTrace() {
        return null;
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public Throwable initCause(Throwable initialCause) {
        if (cause == this ) {
            if (initialCause != this ) {
                cause = initialCause;
                return this ;
            }
            throw new IllegalArgumentException(
                                               "A throwable cannot be its own cause.");
        }
        // second call of initCause(Throwable)
        throw new IllegalStateException(
                                        "A cause can be set at most once."
                                        + " Illegal attempt to re-set the cause of "
                                        + this );
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public void printStackTrace() {
        System.err.println("Stack traces aren't supported currently: " + getClass().getName() + " thrown: " + getMessage());
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public void printStackTrace(PrintStream ps) {
        ps.println("Stack traces aren't supported currently: " + getClass().getName() + " thrown: " + getMessage());
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public void printStackTrace(PrintWriter pw) {
        pw.println("Stack traces aren't supported currently: " + getClass().getName() + " thrown: " + getMessage());
    }
    
    private void initStackTrace() {
    }
        
    /**
     * @com.intel.drl.spec_ref 
     */
    public void setStackTrace(StackTraceElement[] stackTrace) {
    }
    
    /**
     * @com.intel.drl.spec_ref 
     */
    public String toString() {
        String str = getMessage();
        return getClass().getName() + (str == null ? "" : ": " + str);
    }
}