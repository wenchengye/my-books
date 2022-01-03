/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import org.apache.log4j.Logger;

public class Test {
	
  public static void main(String[] args) {

    Logger logger = Logger.getLogger("com.pragprog.dms.Search");

    logger.debug("Debug message");
    logger.info("Info message");
    logger.warn("Warning message");
    logger.error("Error messsage");
    logger.fatal("Fatal message");

    logger = Logger.getLogger("dms.monitoring");
    logger.info("Info message for monitoring");

    logger = Logger.getLogger("sales");
    logger.info("Joe (joe@xyz.com) ordered 10 books!");
  }
}
