/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;

public class TestClassComposite extends TestCase {
  
  public TestClassComposite(String method) {
    super(method);
  }
  
  static public Test suite() {
    TestSuite suite = new TestSuite();
    // Grab everything:
    suite.addTestSuite(TestClassOne.class); 
    // Use the suite method:
    suite.addTest(TestClassTwo.suite()); 
    return suite;
  }
  
}
