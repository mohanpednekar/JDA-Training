/*******************************************************************
 * Purpose: to check whether two strings are nagrams of each other
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.algorithm_programs;

import com.jda.utility.Util;
import com.jda.utility.Utility;

public class Anagrams {
	public static void main(String[] args) {
		Utility utility = new Utility();
		System.out.println("Enter first string");

		String string1 = utility.readString();
		
		System.out.println("Enter second string");

		String string2 = utility.readString();

		if (Util.areAnagrams(string1, string2)) {
			System.out.println("Anagrams");
		} else {
			System.out.println("Not Anagrams");
		}
	}
	
}
