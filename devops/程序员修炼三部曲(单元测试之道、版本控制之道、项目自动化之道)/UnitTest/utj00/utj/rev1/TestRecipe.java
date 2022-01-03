/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import junit.framework.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class TestRecipe extends TestCase {

  public void testSaveandRestore() throws IOException {

    final String test_name = 
      "Cheeseburger";
    final String test_ing1 = 
      "1/4 lb ground sirloin";
    final String test_ing2 = 
      "3 slices Vermont cheddar cheese";
    final String test_ing3 = 
      "2 slices maple-cured bacon";

    // Save one out
    Recipe rec = new Recipe();
    rec.setName(test_name);
    rec.addIngredient(test_ing1);
    rec.addIngredient(test_ing2);
    rec.addIngredient(test_ing3);

    RecipeFile filer = new RecipeFile();
    filer.save("test.recipe", rec);

    try {
      // Now get it back
      Recipe rec2 = new Recipe();
      filer = new RecipeFile();
      rec2 = filer.load("test.recipe");
      
      assertEquals(test_name, rec2.getName());
      Iterator itr = rec2.getIngredients();
      
      assertEquals(test_ing1, itr.next());
      assertEquals(test_ing2, itr.next());
      assertEquals(test_ing3, itr.next());
      assertFalse(itr.hasNext());
    } finally {
      new File("test.recipe").delete();
    }

  }
}
