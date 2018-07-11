/**********************************************************************
 * Purpose: Contains all the utilities used while writing programs for JDA
 * Traininig
 *
 * @author Mohan Pednekar
 * @version 4.0
 * @since 04-07-2018
 ***********************************************************************/

package com.jda.utility;

import java.util.Collection;
import java.util.Scanner;

public class Utility {
	
	// defines an enum for the only two possibilities of coin faces
	enum CoinFace {
	    // head and tail initialised with zero frequency
		HEAD(0), TAIL(0);
		
		// stores the frequency of the corresponding coinface
		private int count;
		
		// initialises the frequency of the coinface
		CoinFace(int n) {
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
			for (int i = 0; i < nFlips; i++) {
				flipACoin();
			}
		}
		
		// performs a coin flip and returns the result.
		CoinFace flipACoin() {
			double randomNumber = Math.random();
			if (randomNumber < 0.5) return CoinFace.HEAD.toss();
			/* else */
			return CoinFace.TAIL.toss();
		}
		
		// finds percentage of of heads out of the total coinflips
		public float percentageOfHeads() {
			float percentage = CoinFace.HEAD.frequency() / (float) nCoinFlips;
			return percentage * 100;
		}
	}
	
	public enum Result {
		WIN, LOSS
	}
	
	public static double euclideanDistance(double x1, double y1, double x2, double y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}
	
	public static int factorial(int length) {
		if (length == 0) return 1;
		return length * factorial(length - 1);
	}
	
	public static <T> void printArray(T[][] array, int rows, int columns) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
		// TODO print
	}
	
	private Scanner scanner;
	
	public Utility() {
		// scanner initialization for all the input
		scanner = new Scanner(System.in);
	}
	
	// checks whether the number of arguments is n
	public boolean checkCmdArgs(String[] args, int n) {
		if (args.length < n) {
			System.out.println("Too few arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
		}
		if (args.length > n) {
			System.out.println("Too many arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
		}
		return args.length == n;
	}
	
	/**
	 * @param stake
	 *            the amount at stake each day
	 * @param goal
	 *            the desired winning amount each day
	 * @param bet
	 *            the amount betted per play
	 * @return whether the goal amount was won or lost
	 */
	public Result gamble(int stake, int goal, int bet) {
		int balance = stake;
		CoinFlip coinFlip = new CoinFlip(0);
		while (true) {
			if (coinFlip.flipACoin() == CoinFace.HEAD) {
				balance += bet;
			} else {
				balance -= bet;
			}
			if (balance >= goal) return Result.WIN;
			if (balance <= 0) return Result.LOSS;
		}
	}
	
	/**
	 * @param n
	 *            the order of Harmonic number desired
	 * @return the nth harmonic number
	 */
	public double harmonicNumber(int n) {
		
		double result = 0;
		for (int i = 1; i <= n; i++) {
			result += 1.0 / i;
		}
		return result;
	}
	
	// checks whether the year provided is leap year or not
	public boolean isLeapYear(int year) {
		if (year % 4 != 0) return false; // year not divisible by 4 is not leap
		if (year % 400 == 0) return true; // year divisible by 400 is leap
		return year % 100 != 0;
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
		for (int i = 0; i < n; i++) {
			result *= x;
		}
		return result;
	}
	
	// finds the smallest prime factor of the number n
	public int primeFactor(int n) {
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
	
	public int[] readIntegerArray(int size) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = scanner.nextInt();
		}
		return array;
	}
	
	public int[][] readIntegerArray(int rows, int columns) {
		int[][] array = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				array[i][j] = scanner.nextInt();
			}
		}
		return array;
	}
	
	/*
	 * // reads a line from input stream delimited by newline characters public
	 * String readLine() { return scanner.nextLine(); } // reads a real number
	 * (double) from input stream public double readReal() { return
	 * scanner.nextDouble(); }
	 */
	// reads a string from input stream delimited by any whitespace
	public String readString() {
		return scanner.next();
	}
	
	// converts a string into positive integer if possible, otherwise returns -1
	public int stringToPositiveInteger(String string) {
		int n;
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
	
	public StringBuilder toStringBuilder(Collection<Integer> collection) {
		StringBuilder sb = new StringBuilder();
		collection.forEach(item -> sb.append(item).append(" "));
		return sb;
	}
}
