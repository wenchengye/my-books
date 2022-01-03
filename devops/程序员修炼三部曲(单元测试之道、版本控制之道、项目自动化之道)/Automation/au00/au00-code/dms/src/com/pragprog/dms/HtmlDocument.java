/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import java.io.*;
import org.w3c.dom.*;
import org.w3c.tidy.Tidy;

public class HtmlDocument {

    private Element rootElement;

    public HtmlDocument(File file) throws IOException {
        Tidy tidy = new Tidy();
        tidy.setQuiet(true);
        tidy.setShowWarnings(false);
        org.w3c.dom.Document root = tidy.parseDOM(new FileInputStream(file),
            null);
        rootElement = root.getDocumentElement();
    }

    public String getTitle() {
        String title = "";
        NodeList nodes = rootElement.getElementsByTagName("title");
        if (nodes.getLength() > 0) {
            Element titleElement = ((Element) nodes.item(0));
            Text text = (Text) titleElement.getFirstChild();
            if (text != null) {
                title = text.getData();
            }
        }
        return title;
    }

    public String getBody() {
        String body = "";
        NodeList nodes = rootElement.getElementsByTagName("body");
        if (nodes.getLength() > 0) {
            body = getBodyText(nodes.item(0));
        }
        return body;
    }

    private String getBodyText(Node bodyNode) {
        NodeList nodes = bodyNode.getChildNodes();
        StringBuffer text = new StringBuffer();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node nextNode = nodes.item(i);
            switch (nextNode.getNodeType()) {
            case Node.ELEMENT_NODE:
                text.append(getBodyText(nextNode));
                text.append(" ");
                break;
            case Node.TEXT_NODE:
                text.append(((Text) nextNode).getData());
                break;
            }
        }

        return text.toString();
    }
}
