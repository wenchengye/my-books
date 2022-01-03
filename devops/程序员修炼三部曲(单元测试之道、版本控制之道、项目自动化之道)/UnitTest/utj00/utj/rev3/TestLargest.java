/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;

public class TestLargest extends TestCase {

  public TestLargest(String name) {
    super(name);
  }

  public void testOrder() {
    assertEquals(9, Largest.largest(new int[] {9, 8, 7}));
        assertEquals(9, Largest.largest(new int[] {7, 9, 8}));
        assertEquals(9, Largest.largest(new int[] {7, 8, 9}));
  }
  
  public void testNegative() {
        assertEquals(-7, Largest.largest(new int[] {-9, -8, -7}));
  }

  public void testEmpty1() {
    boolean got_exception = false;

    try {
      Largest.largest(new int[] {});
    } catch (RuntimeException e) {
      got_exception = true;
    }

    assertTrue(got_exception);
  }

  public void testEmpty2() {

    try {
      Largest.largest(new int[] {});
      fail("Should have thrown an exception");
    } catch (RuntimeException e) {
      assertTrue(true);
    }
  }



}
