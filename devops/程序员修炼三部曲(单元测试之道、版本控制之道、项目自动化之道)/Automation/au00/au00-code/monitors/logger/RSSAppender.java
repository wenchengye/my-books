/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

public class RSSAppender extends AppenderSkeleton {

  protected void append(LoggingEvent event) {
    // update an RSS feed
  }

  public boolean requiresLayout() {
    return false;
  }

  public void close() { }
}
