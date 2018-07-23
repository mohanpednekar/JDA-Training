/*******************************************************************
 * Purpose: Find the Nth harmonic number;
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 *******************************************************************/

package com.jda.functionalprograms;

import com.jda.utility.Reader;
import com.jda.utility.Utility;

public
class HarmonicNumber {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    Utility.printLine("Which harmonic number do you wath to find?");
    int n = reader.readInteger();
    if (n < 1) { Utility.printLine("Enter a positive number"); }
    double result = Utility.harmonicNumber(n);
    Utility.printLine("The " + Utility.ordinal(n) + " harmonic number is " + result);
  }
}
