/**********************************************************************
 * Purpose: Contains all the utilities used while writing programs for JDA
 * Traininig
 *
 * @author Mohan Pednekar
 * @version 4.0
 * @since 04-07-2018
 ***********************************************************************/

package com.jda.utility;

import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
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
		
		// returns the frequency of the corresponding coinface
		public int frequency() {
			return count;
		}
		
		// increments the frequency of the coinface when tossed and returns its
		// own instance for further use if needed
		public CoinFace toss() {
			count++;
			return this;
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
			if (randomNumber < 0.5) return CoinFace.HEAD.toss();
			/* else */ return CoinFace.TAIL.toss();
			
		}
		
		// finds percentage of of heads out of the total coinflips
		public float percentageOfHeads() {
			float percentage = CoinFace.HEAD.frequency() / (float) nCoinFlips;
			return percentage * 100;
		}
		
	}
	
	Scanner scanner;
	
	public Utility() {
		// scanner initialization for all the input
		scanner = new Scanner(System.in);
	}
	
	// checks whether the number of arguments is n
	public boolean checkCmdArgs(String[] args, int n) {
		if (args.length < n)
		    System.out.println("Too few arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
		if (args.length > n)
		    System.out.println("Too many arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
		return args.length == n;
	}
	
	/**
	 * @param n
	 * @return the nth harmonic number
	 */
	public double harmonicNumber(int n) {

		double result = 0;
		for (int i = 1; i <= n; i++)
			result += 1.0 / i;
		return result;
	}
	
	// checks whether the year provided is leap year or not
	public boolean isLeapYear(int year) {
		if (year % 4 != 0) return false; // year not divisible by 4 is not leap
		if (year % 400 == 0) return true; // year divisible by 400 is leap
		if (year % 100 == 0) return false; // year divisible by 100 but not
		                                   // divisible by 400 is not
		// leap
		return true; // year divisible by 4 but not divisible by 100 is leap
	}
	
	// appends an ordinal suffix to the number
	public String ordinal(int n) {
		if (n % 100 > 10 && n % 100 < 20) return n + "th";
		switch (n % 10) {
			case 1:
				return n + "st";
			case 2:
				return n + "nd";
			case 3:
				return n + "rd";
			default:
				return n + "th";
		}
	}
	
	// calculates x^n for non-negative n;
	public int power(int x, int n) {
		int result = 1;
		for (int i = 0; i < n; i++)
			result *= x;
		return result;
	}
	
	// finds the smallest prime factor of the number n
	public int primefactor(int n) {
		for (int i = 2; i * i <= n; i++)
			if (n % i == 0) return i;
		return n;
	}
	
	public void print(String string) {
		System.out.print(string);
	}
	
	public void printLine(String string) {
		System.out.println(string);
	}
	
	// reads an integer from input stream
	public int readInteger() {
		return scanner.nextInt();
	}
	
	// reads a line from input stream delimited by newline characters
	public String readLine() {
		return scanner.nextLine();
	}
	
	// reads a real number (double) from input stream
	public double readReal() {
		return scanner.nextDouble();
	}
	
	// reads a string from input stream delimited by any whitespace
	public String readString() {
		return scanner.next();
	}
	
	// converts a string into positive integer if possible, otherwise returns -1
	public int stringToPositiveInteger(String string) {
		int n = -1;
		try {
			n = Integer.parseInt(string);
			if (n >= 0) return n;
		} catch (NumberFormatException e) {
			// invoked only when parsing an integer fails
			System.out.println("The value given is not an integer");
			return -1;
		}
		// when n is negative
		System.out.println("The value given is not a positive integer");
		return -1;
	}

	public StringBuilder toStringBuilder(ArrayList<Integer> nums) {
		StringBuilder sb = new StringBuilder();
		if (nums.size() > 0) sb.append(nums.get(0));
		for (int i = 1; i < nums.size(); i++)
			sb.append(", ").append(nums.get(i));
		return sb;
	}
	
}
