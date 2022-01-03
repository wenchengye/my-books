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
    assertEquals(9, Largest.largest(new int[] {9,8,7}));
    assertEquals(9, Largest.largest(new int[] {7,9,8}));
    assertEquals(9, Largest.largest(new int[] {7,8,9}));
  }


  public void testDups() {
    assertEquals(9, Largest.largest(new int[] {9,7,9,8}));
  }



  public void testOne() {
     assertEquals(1, Largest.largest(new int[] {1}));
  }

  

  public void testNegative() {
    int [] negList = new int[] {-9, -8, -7};
    assertEquals(-7, Largest.largest(negList));
  }



}
