/**************************************************
 * Purpose: Finds the nth power of 2
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since 05-07-2018
 **************************************************/

package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;

public
class PowerOfTwo {

  public static
  void main(String[] args) {

    Reader reader = new Utility().new Reader();

    // checks whether a command line argument is provided
    if (!Utility.checkCmdArgs(args, 1)) { return; }

    int n = Utility.stringToPositiveInteger(args[0]);
    if (n == -1) { return; }
    if (n >= 31) { Utility.printLine("Please input a power less than 31"); }
    int result = Utility.power(2, n);

    Utility.printLine("The " + Utility.ordinal(n) + " power of 2 is " + result);
  }
}
