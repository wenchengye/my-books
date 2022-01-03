/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;
import junit.extensions.*;

public class TestClassTwo extends TestCase {

  private static TSP tsp;
  
  public TestClassTwo(String method) {
    super(method);
  }
  
  // This one takes a few hours...
  public void testLongRunner() {
    assertEquals(2300, tsp.shortestPath(50));
  }
  
  public void testShortTest() {
    assertEquals(140, tsp.shortestPath(5));
  }
  
  public void testAnotherShortTest() {
    assertEquals(586, tsp.shortestPath(10));
  }
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    // Only include short tests
    suite.addTest(new TestClassTwo("testShortTest"));
    suite.addTest(new TestClassTwo(
                               "testAnotherShortTest"));

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
    tsp = new TSP();
    tsp.loadCities("EasternSeaboard");
  }
  
  public static void oneTimeTearDown() {
    // one-time cleanup code goes here...
    tsp.releaseCities();
  }

}
