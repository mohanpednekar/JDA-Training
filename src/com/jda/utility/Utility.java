package com.jda.utility;

import java.util.Scanner;

public class Utility {
	Scanner scanner;

	public void print(String string) {
		System.out.print(string);
	}

	public void printLine(String string) {
		System.out.println(string);
	}

	public Utility() {
		// scanner initialization for all the input
		scanner = new Scanner(System.in);
	}

	// reads an integer from input stream
	public int readInteger() {
		return scanner.nextInt();
	}

	// reads a real number (double) from input stream
	public double readReal() {
		return scanner.nextDouble();
	}

	// reads a string from input stream delimited by any whitespace
	public String readString() {
		return scanner.next();
	}

	// reads a line from input stream delimited by newline characters
	public String readLine() {
		return scanner.nextLine();
	}

	// checks whether the year provided is leap year or not
	public boolean isLeapYear(int year) {
		if (year % 4 != 0)
			return false; // year not divisible by 4 is not leap
		if (year % 400 == 0)
			return true; // year divisible by 400 is leap
		if (year % 100 == 0)
			return false; // year divisible by 100 but not divisible by 400 is not
		// leap
		return true; // year divisible by 4 but not divisible by 100 is leap
	}

	// defines an enum for the only two possibilities of coin faces
	enum CoinFace {
		// head and tail initialised with zero frequency
		HEAD(0), TAIL(0);

		// stores the frequency of the corresponding coinface
		private int count;

		// initialises the frequency of the coinface
		private CoinFace(int n) {
			count = n;
		}

		// increments the frequency of the coinface when tossed and returns its
		// own instance for further use if needed
		public CoinFace toss() {
			count++;
			return this;
		}

		// returns the frequency of the corresponding coinface
		public int frequency() {
			return count;
		}
	}

	public class CoinFlip {
		private int nCoinFlips;

		// flips a coin n times
		public CoinFlip(int nFlips) {
			nCoinFlips = nFlips;
			for (int i = 0; i < nFlips; i++)
				flipACoin();
		}

		// performs a coin flip and returns the result.
		private CoinFace flipACoin() {
			double randomNumber = Math.random();
			if (randomNumber < 0.5)
				return CoinFace.HEAD.toss();
			/* else */ return CoinFace.TAIL.toss();

		}

		// finds percentage of of heads out of the total coinflips
		public float percentageOfHeads() {
			float percentage = CoinFace.HEAD.frequency() / (float) nCoinFlips;
			return percentage * 100;
		}

	}

	//checks whether the number of arguments is n
	public boolean checkCmdArgs(String[] args, int n) {
		if (args.length < n)
			System.out.println("Too few arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
		if (args.length > n)
			System.out.println("Too many arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
		return args.length == n;
	}

	//	converts a string into positive integer if possible, otherwise returns -1
	public int stringToPositiveInteger(String string) {
		int n = -1;
		try {
			n = Integer.parseInt(string);
			if(n>=0) return n;
		} catch (NumberFormatException e) {
			// invoked only when parsing an integer fails
			System.out.println("The value given is not an integer");
			return -1;
		}
		// when n is negative
		System.out.println("The value given is not a positive integer");
		return -1;
	}
	// calculates x^n for non-negative n;
	public int power(int x, int n) {
		int result = 1;
		for (int i = 0; i < n; i++)
			result *= x;
		return result;
	}

	public String ordinal(int n) {
		if(n%100>10 && n%100<20) return n+"th";
		switch(n%10){
		case 1: return n+"st";
		case 2: return n+"nd";
		case 3: return n+"rd";
		default:return n+"th";
		}
	}

}
