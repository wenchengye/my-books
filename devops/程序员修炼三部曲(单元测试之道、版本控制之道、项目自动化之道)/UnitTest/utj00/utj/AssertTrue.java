/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

public class AssertTrue {
  public void abort() {}

public void assertTrue(boolean condition) {
  if (!condition) {
    abort();
  }
}


public void assertEquals(int a, int b) {
  assertTrue(a == b);
}

}
