/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms.selftest;

import java.io.File;
import java.io.IOException;
import junit.framework.TestCase;

public class InstallTests extends TestCase {

  public void testJavaVersion() {
    String version = System.getProperty("java.version");
    assertTrue("Incompatible Java version. " +
      "Requires version 1.4.x, but found " + version, 
      version.startsWith("1.4"));
  }

  public void testIndexDirectory() throws IOException {
    File dmsDir = getDirectory("dms.dir");
    File indexDir = new File(dmsDir, "index");
    assertDirectoryExists(indexDir);
    assertDirectoryReadable(indexDir);
    assertDirectoryWritable(indexDir);
  }

  void assertDirectoryExists(File dir) throws IOException {
    assertNotNull(dir);
    assertTrue("Directory doesn't exist: " + dir.getCanonicalPath(), 
      dir.exists());
  }

  void assertDirectoryReadable(File dir) throws IOException {
    assertTrue("Directory not readable: " + dir.getCanonicalPath(), 
      dir.canRead());
  }
    
  void assertDirectoryWritable(File dir) throws IOException{
    assertTrue("Directory not writable: " + dir.getCanonicalPath(), 
      dir.canWrite());
  }
    
  File getDirectory(String propertyName) {
    String dirName = System.getProperty(propertyName);
    assertNotNull("'" + propertyName + "' not defined", dirName);
    return new File(dirName);
  }
}
