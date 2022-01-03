/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.search.*;

public class SearchTest extends DMSTestCase {

    private Search search;

    public SearchTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();

        Indexer indexer = new Indexer();
        indexer.isIncremental(false);
        indexer.setIndexDirectory(new File(indexDir));
        indexer.setFile(getDocument("GettysburgAddress.html"));
        indexer.index();
        indexer.setFile(getDocument("LastPublicAddress.html"));
        indexer.isIncremental(true);
        indexer.index();

        search = new Search(indexDir);
    }

    public void tearDown() throws IOException {
        search.close();
    }

    public void testTitleSearch() throws Exception {
        Hits hits = search.searchTitle("Address");
        assertEquals(2, hits.length());
    }

    public void testContentSearch() throws Exception {
        Hits hits = search.searchContents("nation OR national");
        assertEquals(2, hits.length());
    }
}
