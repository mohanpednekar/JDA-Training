package com.jda.functionalprograms;

import com.jda.utility.Utility;

public
class ZeroSumTriples {
	public static
	void main(String[] args) {
		Utility utility = new Utility();
		utility.printLine("How many integers do you want to read?");
		int n = utility.readInteger();
		utility.printLine("Enter " + n + " integers");
		int[] array = utility.readIntegerArray(n);
		findZeroSumTriples(array);

	}

	private static
	void findZeroSumTriples(int[] array) {

	}
}
