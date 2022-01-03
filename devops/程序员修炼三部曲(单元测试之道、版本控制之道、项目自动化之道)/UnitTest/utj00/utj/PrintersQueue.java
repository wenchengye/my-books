/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class PrintersQueue {

  private class Comp implements Comparator {

    public int compare(Object o1, Object o2) {
      ScheduledItem a = (ScheduledItem)o1;
      ScheduledItem b = (ScheduledItem)o2;
      if (a.getPriority() < b.getPriority()) return -1;
      if (a.getPriority() > b.getPriority()) return 1;
      return 0;
    }

    public boolean equals(Object obj) {
      return obj instanceof Comp;
    }
    
  }

  private ArrayList list;


  /** 
   * Add the named book to the schedule with the
   * given priority (higher numbers go first)
   */
  public void addToSchedule(String book_name, 
                            int priority, 
                            Date duedate)

  {
    ScheduledItem item = new ScheduledItem(book_name, priority, duedate);
    list.add(item);

  }


  /* 
   * Return a list of ScheduledItem objects in priority order
   */
  public Iterator listSchedule()

  {
    Object[] arr = list.toArray();
    Arrays.sort(arr, 0, arr.length-1, new Comp());
    return null; //MISSING: redo this example?
  }
}
