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
import com.jda.utility.Utility.Reader;

public class Anagrams {
	public static void main(String[] args) {
    Reader reader = new Utility().new Reader();
		System.out.println("Enter first string");

    String string1 = reader.readString();

		System.out.println("Enter second string");

    String string2 = reader.readString();

		if (Util.areAnagrams(string1, string2)) {
			System.out.println("Anagrams");
		} else {
			System.out.println("Not Anagrams");
		}
	}
}
