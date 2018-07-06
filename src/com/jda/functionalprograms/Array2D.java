package com.jda.functionalprograms;

import com.jda.utility.Utility;

public
class Array2D {
	public static
	void main(String[] args) {
		Utility utility = new Utility();
		utility.printLine("Let's create a 2D array.");
		utility.printLine("Enter the number of rows");
		int rows = utility.readInteger();
		utility.printLine("Enter the number of columns.");
		int columns = utility.readInteger();

		utility.printLine("Enter the array");
		int[][] array = utility.readIntegerArray(rows, columns);

		utility.printLine("The array you input is as follows.");
		utility.printArray(array, rows, columns);
	}
}
