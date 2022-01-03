/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */


public class MyStack {
  public MyStack() {
    stack = new String[100];
    next_index = 0;
  }
  
  public String pop() {
    return stack[--next_index];
  }
  // Delete n items from the stack en-masse
  public void delete(int n) {
    next_index -= n;
  }
  
  public void push(String aString) {
    stack[next_index++] = aString;
  }

  public String top() {
    return stack[next_index-1];
  }



  public void checkInvariant() 
    throws InvariantException {
    // JDK 1.4 can use assert() instead
    if (!(next_index >= 0 && 
          next_index  < stack.length)) {
      throw new InvariantException(
                           "next_index out of range: " + 
                           next_index + 
                           " for stack length " + 
                           stack.length);
    }
  }

  

  private int next_index;
  private String[] stack;
}

