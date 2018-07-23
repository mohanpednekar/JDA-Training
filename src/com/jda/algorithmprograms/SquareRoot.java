package com.jda.algorithmprograms;

import com.jda.utility.Util;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class SquareRoot {

  public static
  void main(String[] args) {
    Reader reader = new Utility().new Reader();
    System.out.println("Enter a number to find square root");
    double input = reader.readDouble();
    System.out.println("The square root is " + Util.sqrt(input));
  }
}
