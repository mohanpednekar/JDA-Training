package com.jda.algorithm_programs;

import com.jda.utility.Util;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class DayOfWeek {

  public static
  void main(String[] args) {
    System.out.println("Enter date in \"mm dd yyyy\" format");
    Reader reader = new Utility().new Reader();
    int mm = reader.readInteger();
    int dd = reader.readInteger();
    int yyyy = reader.readInteger();
    System.out.println(Util.dayOfWeek(mm, dd, yyyy));
  }
}
