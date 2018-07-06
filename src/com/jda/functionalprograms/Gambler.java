

package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Result;

public
class Gambler {
	public static
	void main(String[] args) {
		Utility utility = new Utility();
		utility.printLine("Welcome to Casino Royale!");
		utility.printLine("How much do you want to stake each day?");
		int stake = utility.readInteger();
		utility.printLine("How much do you want to win each day?");
		int goal = utility.readInteger();
		utility.printLine("How many times do you want to gamble?");
		int attempts = utility.readInteger();

		int bet = 1;      //  bet is $1 per play
		int wins = 0;     //  number of winning days
		int losses = 0;   //  number of losing days

		// attempt the gambling game for given number of days
		for (int i = 0; i < attempts; i++) {
			if (utility.gamble(stake, goal, bet) == Result.WIN) wins++;
			else losses++;
		}

		utility.printLine("You won " + wins + " times and lost " + losses + " times");
		utility.printLine("You won " + wins * 100.0 / attempts + "% times");

	}
}
