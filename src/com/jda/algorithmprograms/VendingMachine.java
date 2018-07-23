package com.jda.algorithmprograms;

import com.jda.utility.Reader;
import com.jda.utility.Util;
import com.jda.utility.Utility;
import java.util.ArrayList;
import java.util.HashSet;

public
class VendingMachine {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    System.out.println("Enter the denominations available in your currency followed by 0");
    HashSet<Integer> denominations = new HashSet<>();
    while (true) {
      int denomination = reader.readInteger();
      if (denomination == 0) { break; }
      denominations.add(denomination);
    }
    System.out.println("Enter the amount you want to be disbursed");
    int amount = reader.readInteger();

    ArrayList<Integer> notes = Util.notesNeededToMake(amount, denominations);
    System.out.println("Your notes are");
    System.out.println(Utility.toString(notes));
  }
}
