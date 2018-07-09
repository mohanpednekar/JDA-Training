/*******************************************************************
 * Purpose: to check whether two strings are nagrams of each other
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.algorithm_programs;

import com.jda.utility.Util;

public class Anagrams {
	public static void main(String[] args) {
		String string1 = "He h art";
		String string2 = "ea hrth";

		if (Util.areAnagrams(string1, string2)) System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");
	}
	
}
