/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog;

import org.mortbay.http.HttpServer;
import org.mortbay.jetty.servlet.ServletHandler;

public class WebServer {

  public static void main(String[] args) throws Exception {

    HttpServer server = new HttpServer();
    server.addListener("8080");

    ServletHandler handler = new ServletHandler();
    handler.addServlet("DebugDumpServlet", "/debugdump/*", 
      "com.pragprog.DebugDumpServlet");
    server.getContext("/").addHandler(handler);

    server.start();
  }
}
