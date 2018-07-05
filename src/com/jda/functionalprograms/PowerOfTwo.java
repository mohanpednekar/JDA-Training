package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class PowerOfTwo {

	public static void main(String[] args) {
		
		Utility utility = new Utility();
		
		// checks whether a command line argument is provided
		if (!utility.checkCmdArgs(args,1)) return;
		
		int n=utility.stringToPositiveInteger(args[0]);
		if (n==-1) return;
		if(n>=31) utility.printLine("Please input a power less than 31");
		int result=utility.power(2,n);
		
		utility.printLine("The "+utility.ordinal(n)+ "power of 2 is "+ result);

	}

}
