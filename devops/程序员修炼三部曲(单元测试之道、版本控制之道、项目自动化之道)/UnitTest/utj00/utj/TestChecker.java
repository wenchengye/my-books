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

import junit.framework.*;
import java.util.Calendar;

public class TestChecker extends TestCase {
  
  public void testQuittingTime() {

    MockSystemEnvironment env = 
      new MockSystemEnvironment();

    // Set up a target test time
    Calendar cal = Calendar.getInstance();
    cal.set(Calendar.YEAR, 2004);
    cal.set(Calendar.MONTH, 10);
    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.set(Calendar.HOUR_OF_DAY, 16);
    cal.set(Calendar.MINUTE, 55);
    long t1 = cal.getTimeInMillis();

    env.setTime(t1);

    Checker checker = new Checker(env);

    // Run the checker
    checker.reminder();

    // Nothing should have been played yet
    assertFalse(env.wavWasPlayed());

    // Advance the time by 5 minutes
    t1 += (5 * 60 * 1000);
    env.setTime(t1);

    // Now run the checker
    checker.reminder();

    // Should have played now
    assertTrue(env.wavWasPlayed());

    // Reset the flag so we can try again
    env.resetWav();

    // Advance the time by 2 hours and check
    t1 += 2 * 60 * 60 * 1000;
    env.setTime(t1);

    checker.reminder();
    assertTrue(env.wavWasPlayed());
  }
}
