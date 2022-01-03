/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms.selftest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class ClasspathTests extends TestCase {

  public void testClasspath() throws IOException {

    String dir = System.getProperty("dms.dir");
    assertNotNull("'dms.dir' not defined", dir);

    String dmsDir = new File(dir).getCanonicalPath() + File.separator;
    String libDir = dmsDir + "lib" + File.separator;
    String vendorLibDir = dmsDir + "vendor" + File.separator + 
                          "lib" + File.separator;
    try {

      Iterator files = classpathFiles().iterator();
      assertEquals(libDir + "dms.jar", files.next()); 
      assertEquals(libDir + "dms-tests.jar", files.next()); 
      assertEquals(vendorLibDir + "Tidy.jar", files.next()); 
      assertEquals(vendorLibDir + "junit-3.8.jar", files.next()); 
      assertEquals(vendorLibDir + "lucene-1.3.jar", files.next()); 

    } catch(AssertionFailedError failure) {
      printClasspath();
      throw failure;
    }
  }

  public void printClasspath() throws IOException {
    System.out.println("Classpath being used:");
    Iterator files = classpathFiles().iterator();
    while (files.hasNext()) {
      System.out.println(files.next());
    }
  }
 
  public List classpathFiles() throws IOException {
    String classpath = System.getProperty("java.class.path");
    List files = new ArrayList();
    StringTokenizer fileTokenizer = 
      new StringTokenizer(classpath, File.pathSeparator);
    while (fileTokenizer.hasMoreTokens()) {
      File file = new File(fileTokenizer.nextToken());
      files.add(file.getCanonicalPath());
    }

    return files;
  }
}
