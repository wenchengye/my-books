/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class DMSTestCase extends TestCase {

    protected String docDir;
    protected String indexDir;

    public DMSTestCase(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        docDir = getDirectory("doc.dir");
        indexDir = getDirectory("index.dir");
        Logger.ENABLED = false;
    }

    public String getDirectory(String propertyName) {
        String dir = System.getProperty(propertyName);
        if (dir == null) {
            fail("Property '" + propertyName + "' not defined");
        }
        return dir + File.separator;
    }

    public File getDocument(String fileName) throws IOException {
        return new File(docDir + fileName);
    }
}
