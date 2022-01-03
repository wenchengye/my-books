/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * Compass bearing
 */
public class Bearing {
  protected int bearing; // 0..359

  /**
   * Initialize a bearing to a value from 0..359
   */
  public Bearing(int num_degrees) {
    if (num_degrees < 0 || num_degrees > 359) {
      throw new RuntimeException("Bad bearing");
    }
    bearing = num_degrees;
  }

  /**
   * Return the angle between our bearing and another.
   * May be negative.
   */
  public int angleBetween(Bearing anOther) {
    return bearing - anOther.bearing;
  }
}
