/**
 * Excerpted from the book, "Pragmatic Project Automation"
 * ISBN 0-9745140-3-9
 * Copyright 2004 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

package com.pragprog.dms;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;

public class Indexer {

    private File indexDir;

    private File file;

    private boolean isIncremental;

    private int bytes;

    public Indexer() {
        isIncremental(true);
    }

    public void setFile(File file) {
        assertValidFile(file);
        this.file = file;
    }

    public void setIndexDirectory(File indexDir) {
        assertValidFile(indexDir.getParentFile());
        this.indexDir = indexDir;
    }

    public void isIncremental(boolean incremental) {
        isIncremental = incremental;
    }

    public void index() throws IOException {

        if (indexDir.mkdir()) {
            isIncremental(false);
        }

        Logger.log("Creating index in " + indexDir.getCanonicalPath());
        if (isIncremental) {
            Logger.log("Using incremental mode");
        }

        long startTime = System.currentTimeMillis();

        Analyzer analyzer = new StandardAnalyzer();
        IndexWriter writer = new IndexWriter(indexDir, analyzer, !isIncremental);

        try {

            Document document = asLuceneDocument(file);
            writer.addDocument(document);
            writer.optimize();

        } finally {
            writer.close();
        }

        long elapsed = System.currentTimeMillis() - startTime;
        Logger.log("Indexed " + file.getCanonicalPath() + " (" + bytes
            + " bytes) in " + elapsed + " ms");
    }

    public Document asLuceneDocument(File file) throws IOException {
        HtmlDocument htmlDocument = new HtmlDocument(file);
        Document luceneDocument = new Document();

        String title = htmlDocument.getTitle();
        luceneDocument.add(Field.Text("title", title));
        bytes += title.length();

        String body = htmlDocument.getBody();
        luceneDocument.add(Field.Text("contents", body));
        bytes += body.length();

        return luceneDocument;
    }

    private void assertValidFile(File file) {
        if (!file.exists() || !file.canRead()) {
            throw new IllegalArgumentException("File \""
                + file.getAbsolutePath()
                + "\" does not exist or is not readable.");
        }
    }

    private void parseArgs(String[] args) {

        if (args.length < 2) {
            System.err.println("Usage: java Indexer"
                + " -indexDir [index dir] -file [file]");
            System.exit(1);
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-file")) {
                setFile(new File(args[++i]));
            } else if (args[i].equals("-indexDir")) {
                setIndexDirectory(new File(args[++i]));
            } else if (args[i].equals("-incremental")) {
                isIncremental(true);
            }
        }

        if (file == null) {
            throw new IllegalArgumentException(
                "Missing required argument: -file [file]");
        }

        if (indexDir == null) {
            throw new IllegalArgumentException(
                "Missing required argument: -indexDir [index dir]");
        }
    }

    public static void main(String[] args) throws IOException {
        Indexer i = new Indexer();
        i.parseArgs(args);
        i.index();
    }
}
