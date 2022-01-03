/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

public class DocumentTest extends DMSTestCase {

    private HtmlDocument document;

    public DocumentTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
        document = new HtmlDocument(getDocument("GettysburgAddress.html"));
    }

    public void testTitle() {
        assertEquals("Gettysburg Address", document.getTitle());
    }

    public void testContents() {
        String body = document.getBody();
        assertTrue(body.startsWith("\"Fourscore and seven years ago"));
    }
}
