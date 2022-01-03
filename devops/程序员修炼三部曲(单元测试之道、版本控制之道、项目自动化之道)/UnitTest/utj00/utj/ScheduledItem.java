/**
 * Excerpted from the book, "Pragmatic Unit Testing in Java with JUnit"
 * ISBN 0-9745140-1-2
 * Copyright 2003 The Pragmatic Programmers, LLC.  All Rights Reserved.
 * Visit www.PragmaticProgrammer.com
 */

import java.util.Date;


public class ScheduledItem {


  private String book_name;
  private Date scheduled_date;
  private int priority;

  public ScheduledItem(String name, int priority, Date date) {
    book_name = name;
    scheduled_date = date;
    priority = priority;
  }

  public void setScheduledDate(Date aDate) {
    scheduled_date = aDate;
  }

  public void setPriority(int aPriority) {
    priority = aPriority;
  }


   public String getBookName()

  {
    return book_name;
  }


   public Date getScheduledDate()

  {
    return scheduled_date;
  }


   public int getPriority()

  {
    return priority;
  }


};

