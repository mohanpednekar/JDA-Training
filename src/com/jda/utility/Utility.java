package com.jda.utility;

import java.util.Scanner;

import com.jda.functionalprograms.CoinFace;
import com.jda.functionalprograms.CoinFlip;

public class Utility {

	public class CoinFlip {
		private int nCoinFlips;
		public CoinFlip(int nFlips){
			nCoinFlips=nFlips;
			for(int i=0;i<nFlips;i++)			flipACoin();
		}
	
		private CoinFace flipACoin() {
			double randomNumber=Math.random();
			if(randomNumber<0.5) return CoinFace.HEAD.toss();
			/* else */ 	return CoinFace.TAIL.toss();
			
		}
	
		public static void main(String[] args) {
			Scanner scanner= new Scanner(System.in);
			System.out.println("How many times do you want to flip coin?");
			int nCoinFlips=scanner.nextInt();
			
			CoinFlip experiment=new CoinFlip(nCoinFlips);
			float percentageHeads=experiment.percentageOfHeads();
			
			System.out.println("You flipped heads "+ percentageHeads + "% times and tails "+(100-percentageHeads)+ " times.");
			}
	
		private  float percentageOfHeads() {
			float percentage=CoinFace.HEAD.frequency()/(float)nCoinFlips;
			return percentage*100;
		}
	
	}

}
