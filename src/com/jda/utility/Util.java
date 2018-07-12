/*******************************************************************
 * Purpose: Contains all utilities for Algorithm programs
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

	public static class Stopwatch {
		private long	begin;
		private long	end;

		public Stopwatch() {
			begin = 0;
			end = 0;
		}

		public long elapsedTimeNanos() {
			return end - begin;
		}
		
		public double elapsedTimeSeconds() {
			return elapsedTimeNanos() * 1e-9;
		}

		public void start() {
			begin = System.nanoTime();
		}

		public void stop() {
			end = System.nanoTime();
		}
	}
	
	/**
	 * checks whether the given strings can be formed by rearranging the letters
	 * in each other
	 *
	 * @return
	 */
	
	public static boolean areAnagrams(String string1, String string2) {
		List<Character> s1 = stringToCharacterList(string1);
		List<Character> s2 = stringToCharacterList(string2);
		Collections.sort(s1);
		Collections.sort(s2);
		return s1.equals(s2);
	}
	
	/**
	 * @param items
	 * @return
	 */
	public static <T> ArrayList<T> bubbleSort(ArrayList<T> items) {
		ArrayList<T> sorted = items;
		int n = sorted.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				T input = sorted.get(j);
				T input2 = sorted.get(j + 1);
				if (compare(input, input2) > 0) {
					Collections.swap(sorted, j, j + 1);
				}
			}
		}
		return sorted;
	}
	
	/**
	 * @param input
	 * @param input2
	 * @return
	 */
	private static <T> int compare(T t, T t2) {
		if (t.getClass().toString().endsWith("Integer")) return ((Integer) t).compareTo((Integer) t2);
		if (t.getClass().toString().endsWith("String")) return ((String) t).compareToIgnoreCase((String) t2);
		return 0;
	}
	
	/**
	 * @param i
	 * @param j
	 * @param n
	 * @return
	 */
	public static int guess(int low, int high, int n) {
		if (low == high) return low;
		System.out.println(n + " attempt" + (n > 1 ? "s" : "") + " left");
		if (n == 0) return -1;
		int mid = (high + low) / 2;
		StringBuilder query = new StringBuilder();
		query.append("Is the number ");
		if (low != mid) {
			query.append("between ");
		}
		query.append(low);
		if (low != mid) {
			query.append(" and ").append(mid);
		}
		query.append("?");
		System.out.println(query);
		Utility utility = new Utility();
		boolean correctGuess = utility.readBoolean("y", "n");
		return correctGuess ? guess(low, mid, n - 1) : guess(mid + 1, high, n - 1);
	}
	
	public static boolean isPalindrome(String string) {
		String original = string.replace("\\s", "").toLowerCase();
		String reversed = new StringBuilder(original).reverse().toString();
		return original.equals(reversed);
	}
	
	/**
	 * @param n
	 * @return
	 */
	public static int log2(int n) {
		return 32 - Integer.numberOfLeadingZeros(n);
	}
	
	/**
	 * @param maxPrime
	 *            the limit for the largest prime number to find
	 * @return list of all prime numbers upto maxPrime
	 */
	public static ArrayList<Integer> primesUpto(int maxPrime) {
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 2; i <= maxPrime; i++) {
			nums.add(i);
		}
		ArrayList<Integer> primes = new ArrayList<>();
		while (!nums.isEmpty()) {
			Integer nextPrime = nums.remove(0);
			primes.add(nextPrime);
			nums.removeIf(n -> n % nextPrime == 0);
		}
		return primes;
	}
	
	/**
	 * @param string1
	 * @return list of all the characters (in lowercase) present in the string
	 *         excluding whitespace
	 */
	private static List<Character> stringToCharacterList(String string1) {
		return string1.replaceAll("\\s", "").toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toList());
	}
}
