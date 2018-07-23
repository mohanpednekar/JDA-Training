package com.jda.utility;

import java.util.Scanner;

public
class Reader {

  private Scanner scanner;

  public
  Reader() {
    scanner = new Scanner(System.in);
  }

  public
  double readDouble() {
    return scanner.nextDouble();
  }

  /**
   * @param positive
   * @param negative
   * @return
   */
  public
  boolean readBoolean(String positive, String negative) {
    return scanner.next().toLowerCase().startsWith(positive);
  }

  // reads an integer from input stream
  public
  int readInteger() {
    return scanner.nextInt();
  }

  public
  int[] readIntegerArray(int size) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = scanner.nextInt();
    }
    return array;
  }

  public
  int[][] readIntegerArray(int rows, int columns) {
    int[][] array = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        array[i][j] = scanner.nextInt();
      }
    }
    return array;
  }

  /*
   * // reads a line from input stream delimited by newline characters public
   * String readLine() { return scanner.nextLine(); } // reads a real number
   * (double) from input stream public double readReal() { return
   * scanner.nextDouble(); }
   */
  // reads a string from input stream delimited by any whitespace
  public
  String readString() {
    return scanner.next();
  }

  public
  String readLine() {
    return scanner.nextLine();
  }

  public
  long readLong() {
    return Long.parseLong(scanner.next());
  }
}
