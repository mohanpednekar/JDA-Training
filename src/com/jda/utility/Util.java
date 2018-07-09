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
	
	public static boolean isPalindrome(String string) {
		String original = string.replace("\\s", "").toLowerCase();
		String reversed = new StringBuilder(original).reverse().toString();
		return original.equals(reversed);
	}
	
	/**
	 * @param maxPrime
	 *            the limit for the largest prime number to find
	 * @return list of all prime numbers upto maxPrime
	 */
	public static ArrayList<Integer> primesUpto(int maxPrime) {
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 2; i <= maxPrime; i++)
			nums.add(i);
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
