/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.algorithm_programs;

import java.util.ArrayList;

import com.jda.utility.Util;

public class Primes {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxPrime = 1000;
		ArrayList<Integer> primes = Util.primesUpto(maxPrime);
		primes.forEach(System.out::println);
	}
	
}
