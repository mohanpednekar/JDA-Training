/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.algorithmprograms;

import com.jda.utility.Util;
import java.util.ArrayList;

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
