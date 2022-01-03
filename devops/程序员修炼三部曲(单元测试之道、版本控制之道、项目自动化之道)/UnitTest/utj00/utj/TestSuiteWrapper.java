/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;
import junit.extensions.*;

public class TestSuiteWrapper extends TestCase {

  public static Test suite() {
    // Can manually build up a suite, or just use reflection:
    TestSuite suite = new TestSuite(TestClassOne.class);
    
    TestSetup wrapper = new TestSetup(suite) {
        protected void setUp() {
          oneTimeSetUp();
        }
        protected void tearDown() {
          oneTimeTearDown();
        }
      };
    
    return wrapper;
  }
  
  public static void oneTimeSetUp() {
    // one-time initialization code goes here...
  }
  
  public static void oneTimeTearDown() {
    // one-time cleanup code goes here...
  }
}

