/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

public class Logger {

    public static boolean ENABLED = true;

    public static void log(String message) {
        if (ENABLED) {
            System.out.println(message);
        }
    }
}
