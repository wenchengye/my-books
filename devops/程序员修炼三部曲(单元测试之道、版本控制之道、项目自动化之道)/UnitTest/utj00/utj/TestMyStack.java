/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;

public class TestMyStack extends TestCase {

  public void testEmpty() throws InvariantException {
    MyStack stack = new MyStack();

    stack.checkInvariant();
    stack.push("sample");
    stack.checkInvariant();

    // Popping last element ok
    assertEquals("sample", stack.pop()); 
    stack.checkInvariant();

    // Delete from empty stack
    stack.delete(1); 
    stack.checkInvariant();
  }

}
