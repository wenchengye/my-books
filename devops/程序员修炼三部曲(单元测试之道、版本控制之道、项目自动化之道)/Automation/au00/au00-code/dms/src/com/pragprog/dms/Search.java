/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.*;

public class Search {

    private Searcher searcher;

    public Search(String indexDir) throws IOException {
        searcher = new IndexSearcher(indexDir);
    }

    public void close() throws IOException {
        searcher.close();
    }

    public Hits searchTitle(String term) throws Exception {
        Query query = QueryParser.parse(term, "title", new StandardAnalyzer());
        return searcher.search(query);
    }

    public Hits searchContents(String term) throws Exception {
        Query query = QueryParser.parse(term, "contents",
            new StandardAnalyzer());
        return searcher.search(query);
    }

    public static void main(String[] args) throws Exception {

        if (args.length < 2) {
            System.err.println("Usage: java Search "
                + "<index directory> <query string>");
            System.exit(1);
        }

        String indexDirectory = args[0];
        String term = args[1];

        Search search = new Search(indexDirectory);

        Hits hits = search.searchContents(term);

        for (int i = 0; i < hits.length(); i++) {
            System.out.println("Title: " + hits.doc(i).get("title")
                + "; Score: " + hits.score(i));
        }

        if (hits.length() == 0) {
            System.out.println("No matching documents");
        }

        search.close();
    }
}
