/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

// package...

import junit.framework.*;

// Change all occurrences of "Skeleton" below 
// as appropriate

public class TestSkeleton extends TestCase { 
  
  /**
   * Per-method test set up
   */
  public void setUp() {
  }
  
  /**
   * Per-method test tear down
   */
  public void tearDown() {
  }
  
  /**
   * Add tests here:
   * public void testName() ...
   */
  
  public TestSkeleton(String name) {
    super(name);
  }
  
  /**
   * Default suite method
   */
  public static Test suite() {
    return new TestSuite(TestSkeleton.class);
  }
  
  /** Note -- "main" will only be run when invoked 
   * individually  from the command line 
   * (not via Ant's JUnit Task, etc.)
   */
  
  public static void main (String[] args) {
    TestSuite suite = new TestSuite();
    
    if (args.length != 0) {
      // Run specific tests as indicated from the 
      // command line
      for (int i=0; i< args.length; i++) {
        suite.addTest(new TestSkeleton(args[i]));
      }
    } else {
      // Dynamically discover all of them, or use 
      // user-defined suite
      suite.addTest(TestSkeleton.suite());
    }
    junit.textui.TestRunner.run(suite);
  }
}
