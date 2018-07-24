package com.jda.algorithmprograms;

import com.jda.utility.Maths;
import com.jda.utility.Reader;

public
class SquareRoot {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    System.out.println("Enter a number to find square root");
    double input = reader.readDouble();
    System.out.println("The square root is " + Maths.sqrt(input));
  }
}
