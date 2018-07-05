/*******************************************************************
 * Purpose: Find the Nth harmonic number;
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 *******************************************************************/

package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class HarmonicNumber {
	
	public static void main(String[] args) {
		Utility utility = new Utility();
		utility.printLine("Which harmonic number do you wath to find?");
		int n = utility.readInteger();
		if (n < 1) utility.printLine("Enter a positive number");
		double result = utility.harmonicNumber(n);
		utility.printLine("The " + utility.ordinal(n) + " harmonic number is " + result);
	}
	
}
