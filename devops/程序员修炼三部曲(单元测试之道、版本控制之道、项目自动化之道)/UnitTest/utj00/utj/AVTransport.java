/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

public interface AVTransport {

  /**
   * Move the current position ahead by this many 
   * seconds. Fast-forwarding past end-of-tape 
   * leaves the position at end-of-tape
   */

  public void fastForward(float seconds);

  /**
   * Move the current position backwards by this 
   * many seconds. Rewinding past zero leaves 
   * the position at zero
   */
  public void rewind(float seconds);
  
  /**
   * Return current time position in seconds
   */
  public float currentTimePosition();
  
  /**
   * Mark the current time position with this label
   */
  public void markTimePosition(String name);
  
  /**
   * Change the current position to the one 
   * associated with the marked name
   */
  public void gotoMark(String name);

}
