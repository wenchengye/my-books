/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

/**
 * Excerpted from the book, "Pragmatic Unit Testing"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */


public class MockSystemEnvironment 
  implements Environmental {
  public long getTime() {
    return current_time;
  }

  public void setTime(long aTime) {
    current_time = aTime;
  }

  private long current_time;


  public void playWavFile(String filename) {
    playedWav = true;
  }
  
  public boolean wavWasPlayed() {
    return playedWav;
  }
  
  public void resetWav() {
    playedWav = false;
  }
  
  private boolean playedWav = false;


  // ...
}

