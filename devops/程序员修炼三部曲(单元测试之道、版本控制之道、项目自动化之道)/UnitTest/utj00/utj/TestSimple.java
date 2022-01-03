/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */


import junit.framework.*;

public class TestSimple extends TestCase {

  public TestSimple(String name) {
    super(name);
  }
  
  public void testAdd() {
    assertEquals(2, 1+1);
  }




  public void testAdds() {
    assertEquals(2, 1+1);
    assertEquals(4, 2+2);
    assertEquals(-8, -12+4);
  }



}

