/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DebugDumpServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException {

    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
		
    try {

      out.println("<html>");
      out.println("<body><h1>Debug Dump</h1></body>");
      out.println("</html>");

    } catch(Exception e) {
      out.println("Error: " + e.toString());
    }
  }
}

