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
import org.easymock.MockControl;

public class TestJukebox extends TestCase {

  private Jukebox     mockJukebox;
  private MockControl mockJukebox_control;

  protected void setUp() {
    // Create a control handle to the Mock object
    mockJukebox_control = 
      MockControl.createControl(Jukebox.class);
    
    // And create the Mock object itself
    mockJukebox = 
      (Jukebox) mockJukebox_control.getMock();
  }

  public void testEasyMockDemo() {
    
    // Set up the mock object by calling 
    // methods you want to exist
    mockJukebox.getCurrentSong();
    mockJukebox_control.setReturnValue(
                        "King Crimson -- Epitaph");
      
    // You don't have to worry about the other dozen 
    // methods defined in Jukebox...
      
    // Switch from record to playback
    mockJukebox_control.replay();
    
    // Now it's ready to use:
    assertEquals("King Crimson -- Epitaph", 
                 mockJukebox.getCurrentSong());
  }

}
