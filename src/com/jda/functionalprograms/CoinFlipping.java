/************************************************************
 * 
 * Purpose: Flip a coin and find percentage of Heads and Tails
 * 
 * @author Mohan Pednekar
 * @version 1.0
 * @since 04-07-2018
 * 
************************************************************ */

package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.CoinFlip;

public class CoinFlipping{
	
	public static void main(String[] args) {
		
		Utility utility=new Utility();
		utility.printLine("How many times do you want to flip coin?");

		// nCoinFlips  is the number of times the coin is to be flipped
		int nCoinFlips=utility.readInteger();
		
		//	run the experiment of flipping coin n times
		CoinFlip experiment=utility.new CoinFlip(nCoinFlips);
		
		//	find the percentage of Heads in the experiment
		float percentageHeads=experiment.percentageOfHeads();
		
		//	print result
		//	the percentage of tails is (100- percentage of heads)
		utility.printLine("You flipped heads "+ percentageHeads + "% times and tails "+(100-percentageHeads)+ " times.");
		}
}
