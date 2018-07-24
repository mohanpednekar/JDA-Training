/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 12, 2018
 *******************************************************************/
package com.jda.algorithmprograms;

import com.jda.utility.Games;
import com.jda.utility.Maths;
import com.jda.utility.Printer;

public
class FindMyNumber {

  /**
   * @param args
   */
  public static
  void main(String[] args) {
    int N = Integer.parseInt(args[0]);
    Printer.printLine("Think of a number between 0 and " + (N - 1));
    int n = Maths.log2(N);
    int guessed = Games.guess(0, N - 1, n);
    if (guessed < 0) {
      System.out.println("I ran out of attempts :(");
    } else {
      System.out.println("Your number is " + guessed);
    }
  }
}
