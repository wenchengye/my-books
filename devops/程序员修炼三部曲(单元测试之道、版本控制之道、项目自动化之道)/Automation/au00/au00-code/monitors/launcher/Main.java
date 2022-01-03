/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog;

public class Main {

  public static void main(String[] args) throws Exception {

    Thread.sleep(5000);

    if (args.length > 0) {
      if (args[0].equalsIgnoreCase("exception")) {
        throw new RuntimeException();
      } else if (args[0].equalsIgnoreCase("exit")) {
        System.exit(1);
      } else if (args[0].equalsIgnoreCase("immortal")) {
        while (true) { Thread.sleep(5000); } 
      }
    }
    System.exit(0);
  }
}
