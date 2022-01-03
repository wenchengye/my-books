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

    assertEquals(9, Largest.largest(new int[] {8,9,7}));


    assertEquals(9, Largest.largest(new int[] {7,8,9}));


  }






  public void testEmpty() {
    try {
      Largest.largest(new int[] {});
      fail("Should have thrown an exception");
    } catch (RuntimeException e) {
      assertTrue(true);
    }
  }



  public void testOrder2() {
    int[] arr = new int[3];
    arr[0] = 8;
    arr[1] = 9;
    arr[2] = 7;
    assertEquals(9, Largest.largest(arr));
  }



}

