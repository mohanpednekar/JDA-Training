/*******************************************************************
 * Purpose: To find prime factors of a number
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 *******************************************************************/
package com.jda.functionalprograms;

import java.util.ArrayList;

import com.jda.utility.Utility;

public class Factors {
	
	public static void main(String[] args) {
		Utility utility = new Utility();
		utility.printLine("Enter a number to factorise");
		int n = utility.readInteger();

		ArrayList<Integer> factors = new ArrayList<>();
		int temp = n;
		while (temp > 1) {
			int f = utility.primefactor(temp);
			factors.add(f);
			temp = temp / f;
		}

		utility.printLine("The prime factors of " + n + " are " + utility.toStringBuilder(factors));
	}

}
