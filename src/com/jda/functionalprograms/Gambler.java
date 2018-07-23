

package com.jda.functionalprograms;

import com.jda.utility.Reader;
import com.jda.utility.Utility;
import com.jda.utility.Utility.Result;

public
class Gambler {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    Utility.printLine("Welcome to Casino Royale!");
    Utility.printLine("How much do you want to stake each day?");
    int stake = reader.readInteger();
    Utility.printLine("How much do you want to win each day?");
    int goal = reader.readInteger();
    Utility.printLine("How many times do you want to gamble?");
    int attempts = reader.readInteger();

    int bet = 1;      //  bet is $1 per play
    int wins = 0;     //  number of winning days
    int losses = 0;   //  number of losing days

    // attemptWith the gambling game for given number of days
    for (int i = 0; i < attempts; i++) {
      if (Utility.gamble(stake, goal, bet) == Result.WIN) { wins++; } else { losses++; }
    }

    Utility.printLine("You won " + wins + " times and lost " + losses + " times");
    Utility.printLine("You won " + wins * 100.0 / attempts + "% times");
  }
}
