/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;
import java.lang.reflect.Method;

public class TestFinder {

  /* Note -- "main" will only be run when invoked individually
   * from the command line (not via Ant, etc.).
   * This code dynamically builds a test suite, based either
   * on command-line  arguments, or on 
   * reflection into the specified class.
   */
  
  public static void run(Class which, String[] args) {
    
    TestSuite suite = null;
    
    if (args.length != 0) {
      // Run specific tests as indicated from the command line

      try {
        java.lang.reflect.Constructor ctor;
        ctor = which.getConstructor(new Class[] 
          {String.class});
        suite = new TestSuite();
        for (int i=0; i< args.length; i++) {
          suite.addTest((TestCase)ctor.newInstance(
                                      new Object[]{args[i]}));
        }
      } catch (Exception e) {
        System.err.println("Unable to instantiate " + 
                           which.getName() + 
                           ": " + e.getMessage());
        System.exit(1);
      }
      
    } else {
      // Call the suite() method of the given class, 
      // if there is one
      try {
        Method suite_method = which.getMethod("suite", 
                                              new Class[0]);
        suite = (TestSuite) suite_method.invoke(null, 
                                                null);
      } catch (Exception e) {
        // Whoops!  No public suite() in that class.  
        // Make a default list using reflection:
        suite = new TestSuite(which);
      }
    }
    
    junit.textui.TestRunner.run(suite);
  }
}
