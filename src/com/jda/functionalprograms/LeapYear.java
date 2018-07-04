package com.jda.functionalprograms;

import com.jda.utility.Utility;

public class LeapYear {

	public static void main(String[] args) {
		Utility utility = new Utility();
		utility.print("Enter the year : ");
		int year = utility.readInteger();
		while(year<1000||year>9999) {
			utility.print("Year must be 4 digit.\nEnter the year: ");
			year=utility.readInteger();
		}
		if(utility.isLeapYear(year)) utility.printLine("It is a leap year");
		else utility.printLine("It is not a leap year");

	}

}
