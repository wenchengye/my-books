/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */


import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Iterator;


public class RecipeFile {

  public Recipe load(String fileName) 
    throws IOException {

    BufferedReader in = null;
    Recipe result = new Recipe();

    in = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = in.readLine()) != null){
      int pos = line.indexOf('=');
      String token = line.substring(0, pos);
      String value = line.substring(pos+1);
      if (token.equals("TITLE")) { 
        result.setName(value);
      } else if (token.equals("INGREDIENTS")) {
        int num_lines = Integer.parseInt(value);
        for (int i=0; i < num_lines; i++) {
          line = in.readLine();
          result.addIngredient(line);
        }
      }
    }
    in.close();
    return result;
  }

  public void save(String fileName, Recipe recipe) 
    throws IOException {

    PrintWriter out = new PrintWriter(
                          new FileWriter(fileName));

    out.println("NAME=" + recipe.getName());
    out.println("INGREDIENTS=" + 
                recipe.getNumIngredients());

    Iterator itr = recipe.getIngredients();
    while (itr.hasNext()) {
      out.println(itr.next());
    }
    out.close();
  }
}

