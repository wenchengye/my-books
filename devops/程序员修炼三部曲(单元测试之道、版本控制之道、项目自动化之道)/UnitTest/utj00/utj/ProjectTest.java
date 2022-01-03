/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */


import junit.framework.*;

/**
 * Project-wide base class for Testing
 */
public class ProjectTest extends TestCase {

  /**
   * Assert that the amount of money is an even
   * number of dollars (no cents)
   *
   * @param message Text message to display if the 
   *                                assertion fails
   * @param amount Money object to test
   *
   */

  public void assertEvenDollars(String message, 
                                Money amount) {
    assertEquals(message, 
          amount.asDouble() - (int)amount.asDouble(), 
          0.0, 
          0.001);
  }

  /**
   * Assert that the amount of money is an even
   * number of dollars (no cents)
   *
   * @param amount Money object to test
   *
   */

  public void assertEvenDollars(Money amount) {
    assertEvenDollars("", amount);
  }

}
