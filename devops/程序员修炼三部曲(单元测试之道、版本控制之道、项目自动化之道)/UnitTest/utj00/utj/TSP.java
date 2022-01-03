/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * A brute-force solution to the Travelling Salesman Problem.
 *
 * It will run in exponential time.
 *
 * Better solutions use genetic algorithms and such.
 */

public class TSP {

  /**
   * For the top numCities in our territory, compute the shortest path
   * and return thr total number of miles in that path.
   */
  public int shortestPath(int numCities) {
    // Ha!  Mock object! 
    switch (numCities) {
    case 50: return 2300;
    case 5: return 140;
    case 10: return 586;
    }
    return 0;
  }

  /**
  * Load the cities for the given territory and lock them
  */
  public void loadCities(String name) {
  }

  /**
  * Relase the lock on cities in this territory
  */
  public void releaseCities() {
  }

}
