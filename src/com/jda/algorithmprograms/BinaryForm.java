package com.jda.algorithmprograms;

import com.jda.utility.Reader;
import com.jda.utility.Util;

public
class BinaryForm {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    System.out.println("Enter a number to convert to Binary");
    int number = reader.readInteger();
    System.out.print("The binary form is ");
    String binary = Util.toBinary(number);
    System.out.println(binary);
    String swappedNibbles = Util.swapNibbles(binary);
    System.out.println("After Swapping nibbles : " + swappedNibbles);
    int newNumber = Util.binaryToDecimal(swappedNibbles);
    System.out.println("The new number is " + newNumber);
    System.out.println(
        "The resultant number is " + (Util.isPowerOf2(swappedNibbles) ? "" : "not ") + "a "
            + "power" + " of" + " 2");
  }
}
