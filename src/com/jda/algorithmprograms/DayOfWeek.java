package com.jda.algorithmprograms;

import com.jda.utility.Reader;
import com.jda.utility.Util;
import com.jda.utility.Util.Calendar.Month;

public
class DayOfWeek {

  public static
  void main(String[] args) {
    System.out.println("Enter date in \"mm dd yyyy\" format");
    Reader reader = new Reader();
    int mm = reader.readInteger();
    int dd = reader.readInteger();
    int yyyy = reader.readInteger();
    System.out.println(Util.dayOfWeek(Month.values()[mm - 1], dd, yyyy));
  }
}
