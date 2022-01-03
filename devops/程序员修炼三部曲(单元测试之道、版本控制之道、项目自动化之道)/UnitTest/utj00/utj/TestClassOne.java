/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;

public class TestClassOne extends TestCase {

  public TestClassOne(String method) {
    super(method);
  }
  
  public void testAddition() {
    assertEquals(4, 2+2);
  }
  
  public void testSubtraction() {
    assertEquals(0, 2-2);
  }
  
}
