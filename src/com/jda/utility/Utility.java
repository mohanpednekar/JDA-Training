package com.jda.utility;

import java.util.Scanner;

public class Utility {
	Scanner scanner;

	public  void print(String string){
		System.out.print(string);
	}

	public void printLine(String string){
		System.out.println(string);
	}
	public Utility() {
		scanner = new Scanner(System.in);
	}


		public int readInteger() {
			return scanner.nextInt();
		}

		public double readReal() {
			return scanner.nextDouble();
		}

		public String readString() {
			return scanner.next();
		}

		public String readLine() {
			return scanner.nextLine();
		}
	
		public boolean isLeapYear(int year){
			if(year%4!=0) return false;
			if(year%400==0) return true;
			if(year%100==0) return false;
			return true;
		}

	enum CoinFace {
		HEAD(0), TAIL(0);

		private int count;

		private CoinFace(int n) {
			count = n;
		}

		public CoinFace toss() {
			count++;
			return this;
		}

		public int frequency() {
			return count;
		}
	}

	public class CoinFlip {
		private int nCoinFlips;

		public CoinFlip(int nFlips) {
			nCoinFlips = nFlips;
			for (int i = 0; i < nFlips; i++)
				flipACoin();
		}

		private CoinFace flipACoin() {
			double randomNumber = Math.random();
			if (randomNumber < 0.5)
				return CoinFace.HEAD.toss();
			/* else */ return CoinFace.TAIL.toss();

		}

		public float percentageOfHeads() {
			float percentage = CoinFace.HEAD.frequency() / (float) nCoinFlips;
			return percentage * 100;
		}

	}

}
