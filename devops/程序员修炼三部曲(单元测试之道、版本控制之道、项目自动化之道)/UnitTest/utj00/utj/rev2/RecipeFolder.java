/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class RecipeFolder {

  private static final String base_directory = "./recipes/";

  public Iterator search (String pattern) {
    String[] dir_list;
    ArrayList matches = new ArrayList();

    File path = new File(base_directory);
    dir_list = path.list();

    for (int i=0; i < dir_list.length; i++){
      String file_name = dir_list[i];

      // Truncate the ".txt" suffix if present
      if (file_name.endsWith(".txt")) {
        dir_list[i] = file_name.substring(0, file_name.length() - 4);
      }

      if (file_name.indexOf(pattern) >= 0) {
        matches.add(dir_list[i]);
      }
    }

    return matches.iterator();
  }
  
}
