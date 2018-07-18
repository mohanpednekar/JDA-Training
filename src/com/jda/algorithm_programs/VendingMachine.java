package com.jda.algorithm_programs;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;
import java.util.HashSet;

public
class VendingMachine {

  public static
  void main(String[] args) {
    Reader reader = new Utility().new Reader();
    System.out.println("Enter the denominations available in your currency followed by 0");
    HashSet<Integer> denominations = new HashSet<>();
    while (true) {
      int denomination = reader.readInteger();
      if (denomination == 0) { break; }
      denominations.add(denomination);
    }
    System.out.println("Enter the amount you want to be disbursed");
  }
}
