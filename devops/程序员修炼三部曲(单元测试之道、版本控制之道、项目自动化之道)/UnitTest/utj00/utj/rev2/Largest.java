/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

public class Largest {

  /**
   * Largest
   * @param list A non-empty list of integers
   * @return The largest number in the given list
   */
  public static int largest(int[] list) {
    int index, max=0;
    if (list.length == 0) {
      throw new RuntimeException("largest: Empty list");
    }
    for (index = 0; index < list.length; index++) {
      if (list[index] > max) {
        max = list[index];
      }
    }
    return max;
  }
}
