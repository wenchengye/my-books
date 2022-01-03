/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

public interface StackExercise {
  /** 
    * Return and remove the most recent item from 
    * the top of the  stack.  
    * Throws StackEmptyException
    * if the stack is empty
    */
  public String pop() throws StackEmptyException; 
  
  /**
   * Add an item to the top of the stack.
   */
  public void push(String item);
  
  /** 
    * Return but do not remove the most recent 
    * item from the top of the stack.  
    * Throws StackEmptyException 
    * if the stack is empty
    */
  public String top() throws StackEmptyException;
  
  /**
    * Returns true if the stack is empty.
    */
  public boolean isEmpty();
}
