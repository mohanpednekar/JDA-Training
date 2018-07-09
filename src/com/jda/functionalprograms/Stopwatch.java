package com.jda.functionalprograms;

import com.jda.utility.Utility;

public
class Stopwatch {
	public static
	void main(String[] args) {
		Utility utility = new Utility();
		long start = System.currentTimeMillis();
		doNothing(10e7);
		long end = System.currentTimeMillis();
		utility.printLine("Watch started at " + start);
		utility.printLine("Watch stopped at " + end);
		utility.printLine("The time elapsed was " + (end - start) + " ms");
	}

	//  This function does nothing
	//  Actually, it prints nothing n times
	private static
	void doNothing(double n) {
		for (int i = 0; i < n; i++) System.out.print("");
	}
}
