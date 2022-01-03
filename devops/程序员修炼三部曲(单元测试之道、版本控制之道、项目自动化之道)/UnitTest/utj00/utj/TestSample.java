/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;

public class TestSample extends TestCase {

  public TestSample(String name) { super(name); }

  /**
   * Per-test setup
   */
  public void setUp() {
  }

  /**
   * Per-test teardown
   */
  public void tearDown() {
  }

  /*
   * Tests go here...
   */
  public void testMe() {
    assertTrue(true);
  }
  
  /**
   * Default suite() method discovers all tests... 
   */
  public static Test suite() {
    return new TestSuite(TestSample.class);
  }
  
  public static void main(String[] args) { 
    TestFinder.run(TestSample.class, args);
  }
  
};
