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
 * @author Alexey A. Ivanov
 */
package javax.swing.text.html;

import javax.swing.BasicSwingTestCase;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.html.CSS.Attribute;

import junit.framework.TestCase;

public class StyleSheet_ConvertAttr_DisplayTest extends TestCase {
    private StyleSheet ss;
    private MutableAttributeSet simple;
    private Object cssValue;

    protected void setUp() throws Exception {
        super.setUp();
        ss = new StyleSheet();
        simple = new SimpleAttributeSet();
    }

    public void testDisplayNone() {
        ss.addCSSAttribute(simple, Attribute.DISPLAY, "none");
        cssValue = simple.getAttribute(Attribute.DISPLAY);
        assertEquals("none", cssValue.toString());
    }

    public void testDisplayBlock() {
        ss.addCSSAttribute(simple, Attribute.DISPLAY, "block");
        cssValue = simple.getAttribute(Attribute.DISPLAY);
        assertEquals("block", cssValue.toString());
    }

    public void testDisplayInline() {
        ss.addCSSAttribute(simple, Attribute.DISPLAY, "inline");
        cssValue = simple.getAttribute(Attribute.DISPLAY);
        assertEquals("inline", cssValue.toString());
    }

    public void testDisplayListItem() {
        ss.addCSSAttribute(simple, Attribute.DISPLAY, "list-item");
        cssValue = simple.getAttribute(Attribute.DISPLAY);
        assertEquals("list-item", cssValue.toString());
    }

    public void testDisplayInvalid() {
        ss.addCSSAttribute(simple, Attribute.DISPLAY, "inline-block"); // CSS 2
        cssValue = simple.getAttribute(Attribute.DISPLAY);
        if (BasicSwingTestCase.isHarmony()) {
            assertEquals(0, simple.getAttributeCount());
            assertNull(cssValue);
        } else {
            assertEquals(1, simple.getAttributeCount());
            assertEquals("inline-block", cssValue.toString());
        }
    }
}
