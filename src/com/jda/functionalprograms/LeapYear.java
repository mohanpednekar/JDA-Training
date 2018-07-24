package com.jda.functionalprograms;

import com.jda.utility.Calendar;
import com.jda.utility.Printer;
import com.jda.utility.Reader;

public
class LeapYear {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    Printer.print("Enter the year : ");
    int year = reader.readInteger();
    while (year < 1000 || year > 9999) {
      Printer.print("Year must be 4 digit.\nEnter the year: ");
      year = reader.readInteger();
    }
    if (Calendar.isLeapYear(year)) { Printer.printLine("It is a leap year"); }
    else {
      Printer.printLine("It is not a leap year");
    }
  }
}
