/*******************************************************************
 * Purpose: To find prime factors of a number
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 *******************************************************************/
package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;
import java.util.ArrayList;

public
class Factors {

  public static
  void main(String[] args) {
    Reader reader = new Utility().new Reader();
    Utility.printLine("Enter a number to factorise");
    int n = reader.readInteger();

    ArrayList<Integer> factors = new ArrayList<>();
    int temp = n;
    while (temp > 1) {
      int f = Utility.primeFactor(temp);
      factors.add(f);
      temp = temp / f;
    }

    Utility.printLine("The prime factors of " + n + " are " + Utility.toString(factors));
  }
}
