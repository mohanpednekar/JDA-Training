package com.jda.algorithm_programs;

import com.jda.utility.Util;
import com.jda.utility.Utility;

public
class DayOfWeek {

  public static
  void main(String[] args) {
    System.out.println("Enter date in \"mm dd yyyy\" format");
    Utility utility = new Utility();
    int mm = utility.readInteger();
    int dd = utility.readInteger();
    int yyyy = utility.readInteger();
    System.out.println(Util.dayOfWeek(mm, dd, yyyy));
  }
}
