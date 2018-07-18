package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class LeapYear {

  public static
  void main(String[] args) {
    Reader reader = new Utility().new Reader();
    Utility.print("Enter the year : ");
    int year = reader.readInteger();
    while (year < 1000 || year > 9999) {
      Utility.print("Year must be 4 digit.\nEnter the year: ");
      year = reader.readInteger();
    }
    if (Utility.isLeapYear(year)) { Utility.printLine("It is a leap year"); } else {
      Utility.printLine("It is not a leap year");
    }
  }
}
