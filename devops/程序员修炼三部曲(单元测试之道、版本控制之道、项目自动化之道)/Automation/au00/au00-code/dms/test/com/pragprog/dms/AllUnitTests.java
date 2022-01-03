/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import junit.framework.*;

public class AllUnitTests {

    public static Test suite() {

        TestSuite suite = new TestSuite("DMS Tests");
        suite.addTestSuite(DocumentTest.class);
        suite.addTestSuite(SearchTest.class);
        return suite;
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
