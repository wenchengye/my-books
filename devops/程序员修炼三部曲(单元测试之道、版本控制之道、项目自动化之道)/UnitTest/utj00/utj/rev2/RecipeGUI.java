/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

class RecipeGUI extends Frame {

  private Label titleLabel = 
    new Label("Name of Recipe:", Label.LEFT);
  private TextField titleText = new TextField(30);

  private Label ingredientsLabel = 
    new Label("Ingredients:",Label.LEFT);
  private TextField ingredientsText = new TextField(30);

  private Button ingredientsRemoveSel = 
    new Button("Remove Ingredient");
  private List ingredientsList = new List(12, false);
  private List searchList = new List(12, false);
  
  private Button saveButton = new Button("Save");
  private Button searchButton = new Button("Search");
  private Button exitButton = new Button("Exit");
  private TextField statusText = new TextField(40);

  private RecipeFile record;

  public RecipeGUI() {
    record = new RecipeFile();
  }

  public void removeSel() {
    int count;
    String str;
    str = ingredientsList.getSelectedItem();
    if (str != null) {
      count = ingredientsList.getSelectedIndex();
      ingredientsList.remove(count);
    }
  }
  
  public void addIngredient() {
    String str;
    str = ingredientsText.getText();

    if (str.length() != 0) {
      ingredientsList.add(str);
      ingredientsText.setText("");
    }
  }
        
  public void exit() {
    dispose();
    System.exit(0);
  }
  

  public void save() {
    String str = statusText.getText();
    File theFile = new File("recipes/" + titleText.getText() + ".txt");
    if (str.equals(titleText.getText() + 
                   ".txt Already exists")) {
      //record.save(theFile);
    } else {
      if (theFile.exists() == true) {
        statusText.setText(titleText.getText() + 
                           ".txt Already exists");
      }
      if (theFile.exists() == false) {
        //record.save(theFile);
      }
    }
  }


  public void search() {
    String str;
    String[] dir_list;
    ArrayList matches = new ArrayList();

    str = titleText.getText();
    
    searchList.removeAll();
    statusText.setText("Partial match: "+ titleText.getText());

    File path = new File("recipes/");
    dir_list = path.list();

    for (int i=0; i < dir_list.length; i++){
      String file_name = dir_list[i];

      // Truncate the ".txt" suffix
      if (file_name.endsWith(".txt")) {
        dir_list[i] = file_name.substring(0, file_name.length() - 4);
      }

      System.err.println ( "Checking " + file_name + " for " + str);
      if (file_name.indexOf(str) >= 0) {
        matches.add(dir_list[i]);
      }
    }

    for (int i = 0; i < matches.size(); i++){
      searchList.add(matches.get(i) + ".txt");
    }
  }


  public void showGUI() {
    setTitle("Recipes");

    Panel mainp = new Panel(new FlowLayout());

    Panel p1 = new Panel(new BorderLayout());
    p1.add(titleLabel, BorderLayout.WEST);
    p1.add(titleText, BorderLayout.EAST);
    mainp.add(p1);

    Panel p2 = new Panel(new BorderLayout());
    p2.add(ingredientsLabel, BorderLayout.WEST);
    p2.add(ingredientsText, BorderLayout.EAST);
    mainp.add(p2);

    Panel p3 = new Panel(new BorderLayout());
    p3.add(ingredientsList, BorderLayout.CENTER);
    p3.add(searchList, BorderLayout.EAST);
    p3.add(ingredientsRemoveSel, BorderLayout.SOUTH);
    mainp.add(p3);
  
    Panel p4 = new Panel(new BorderLayout());
    p4.add(saveButton, BorderLayout.WEST);
    p4.add(searchButton, BorderLayout.CENTER);
    p4.add(exitButton, BorderLayout.EAST);
    p4.add(statusText, BorderLayout.SOUTH);
    mainp.add(p4);
    
    // Add the object listeners
    exitButton.addActionListener(new ActionListener() { 
        public void actionPerformed(ActionEvent e) {
          exit(); 
        } 
      });

    ingredientsText.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          addIngredient();
        }
      });

    ingredientsRemoveSel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          removeSel();
        }
      });

    saveButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          save();
        }
      });
    
    searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          search();
        }
      });

    searchList.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          //loadFile();
        }
      });
    
    add(mainp);
    setSize(400,400);
    show();
  }

  public static void main(String args[]){
    RecipeGUI obj = new RecipeGUI();
    obj.showGUI();
  }
}
