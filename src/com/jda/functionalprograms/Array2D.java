package com.jda.functionalprograms;

import com.jda.utility.Reader;
import com.jda.utility.Utility;

public
class Array2D {

  public static
  void main(String[] args) {
    Reader reader = new Reader();
    Utility.printLine("Let's create a 2D array.");
    Utility.printLine("Enter the number of rows");
    int rows = reader.readInteger();
    Utility.printLine("Enter the number of columns.");
    int columns = reader.readInteger();

    Utility.printLine("Enter the array");
    int[][] array = reader.readIntegerArray(rows, columns);
    Integer[][] objArray = getIntegers(rows, columns, array);
    Utility.printLine("The array you input is as follows.");
    Utility.printArray(objArray, rows, columns);
  }

  private static
  Integer[][] getIntegers(int rows, int columns, int[][] array) {
    Integer[][] objArray = new Integer[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) { objArray[i][j] = array[i][j]; }
    }
    return objArray;
  }
}
