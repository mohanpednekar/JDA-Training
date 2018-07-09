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
		Integer[][] objArray = getIntegers(rows, columns, array);
		utility.printLine("The array you input is as follows.");
		Utility.printArray(objArray, rows, columns);
	}

	private static
	Integer[][] getIntegers(int rows, int columns, int[][] array) {
		Integer[][] objArray = new Integer[rows][columns];
		for (int i = 0; i < rows; i++) for (int j = 0; j < columns; j++) objArray[i][j] = array[i][j];
		return objArray;
	}
}
