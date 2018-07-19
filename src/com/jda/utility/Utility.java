/**********************************************************************
 * Purpose: Contains all the utilities used while writing programs for JDA
 * Traininig
 *
 * @author Mohan Pednekar
 * @version 4.0
 * @since 04-07-2018
 ***********************************************************************/

package com.jda.utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public
class Utility {

  public static
  HashSet<ComplexNumber> findRoots(double a, double b, double c) {
    HashSet<ComplexNumber> roots = new HashSet<>();
    double d = discriminant(a, b, c); //or delta
    double real = -b / (2 * a);
    System.out.println(real);

    double img = Math.sqrt(Math.abs(d)) / (2 * a);
    System.out.println(img);
    if (d < 0) {
      roots.add(new ComplexNumber(real, img));
      roots.add(new ComplexNumber(real, -img));
    } else {
      roots.add(new ComplexNumber(real + img, 0));
      roots.add(new ComplexNumber(real - img, 0));
    }

    return roots;
  }

  private static
  double discriminant(double a, double b, double c) {
    return (b * b) - (4 * a * c);
  }

  public static
  double euclideanDistance(double x1, double y1, double x2, double y2) {
    double dx = x1 - x2;
    double dy = y1 - y2;
    return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
  }

  public static
  int factorial(int length) {
    if (length == 0) {
      return 1;
    }
    return length * factorial(length - 1);
  }

  public static
  <T> void printArray(T[][] array, int rows, int columns) {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        System.out.print(array[i][j]);
      }
      System.out.println();
    }
    // TODO print
  }

  // checks whether the number of arguments is n
  public static
  boolean checkCmdArgs(String[] args, int n) {
    if (args.length < n) {
      System.out
          .println("Too few arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
    }
    if (args.length > n) {
      System.out
          .println("Too many arguments. Please provide  " + n + " argument" + (n > 1 ? "s" : ""));
    }
    return args.length == n;
  }

  /**
   * @param stake the amount at stake each day
   * @param goal the desired winning amount each day
   * @param bet the amount betted per play
   * @return whether the goal amount was won or lost
   */
  public static
  Result gamble(int stake, int goal, int bet) {
    int balance = stake;
    CoinFlip coinFlip = new Utility().new CoinFlip(0);
    while (true) {
      if (coinFlip.flipACoin() == CoinFace.HEAD) {
        balance += bet;
      } else {
        balance -= bet;
      }
      if (balance >= goal) {
        return Result.WIN;
      }
      if (balance <= 0) {
        return Result.LOSS;
      }
    }
  }

  /**
   * @param n the order of Harmonic number desired
   * @return the nth harmonic number
   */
  public static
  double harmonicNumber(int n) {

    double result = 0;
    for (int i = 1; i <= n; i++) {
      result += 1.0 / i;
    }
    return result;
  }

  // checks whether the year provided is leap year or not
  public static
  boolean isLeapYear(int year) {
    if (year % 4 != 0) {
      return false; // year not divisible by 4 is not leap
    }
    if (year % 400 == 0) {
      return true; // year divisible by 400 is leap
    }
    return year % 100 != 0;
  }

  // appends an ordinal suffix to the number
  public static
  String ordinal(int n) {
    if (n % 100 > 10 && n % 100 < 20) {
      return n + "th";
    }
    switch (n % 10) {
      case 1:
        return n + "st";
      case 2:
        return n + "nd";
      case 3:
        return n + "rd";
      default:
        return n + "th";
    }
  }

  // calculates x^n for non-negative n;
  public static
  int power(int x, int n) {
    int result = 1;
    for (int i = 0; i < n; i++) {
      result *= x;
    }
    return result;
  }

  // finds the smallest prime factor of the number n
  public static
  int primeFactor(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        return i;
      }
    }
    return n;
  }

  public static
  void print(String string) {
    System.out.print(string);
  }

  public static
  void printLine(String string) {
    System.out.println(string);
  }

  // converts a string into positive integer if possible, otherwise returns -1
  public static
  int stringToPositiveInteger(String string) {
    int n;
    try {
      n = Integer.parseInt(string);
      if (n >= 0) {
        return n;
      }
    } catch (NumberFormatException e) {
      // invoked only when parsing an integer fails
      System.out.println("The value given is not an integer");
      return -1;
    }
    // when n is negative
    System.out.println("The value given is not a positive integer");
    return -1;
  }

  public static
  String toString(Collection<Integer> collection) {
    StringBuilder sb = new StringBuilder();
    collection.forEach(item -> sb.append(item).append(" "));
    return sb.toString();
  }

  // defines an enum for the only two possibilities of coin faces
  enum CoinFace {
    // head and tail initialised with zero frequency
    HEAD(0), TAIL(0);

    // stores the frequency of the corresponding coinface
    private int count;

    // initialises the frequency of the coinface
    CoinFace(int n) {
      count = n;
    }

    // returns the frequency of the corresponding coinface
    public
    int frequency() {
      return count;
    }

    // increments the frequency of the coinface when tossed and returns its
    // own instance for further use if needed
    public
    CoinFace toss() {
      count++;
      return this;
    }
  }

  public
  enum Result {
    WIN, LOSS
  }

  public static
  class Sorting {

    /**
     * Performs bubble sort
     */
    public static
    <T extends Comparable<T>> ArrayList<T> bubbleSort(ArrayList<T> items) {
      int n = items.size();
      for (int i = 0; i < (n - 1); i++) {
        for (int j = 0; j < (n - 1); j++) {
          T input = items.get(j);
          T input2 = items.get(j + 1);
          if (input.compareTo(input2) > 0) {
            Collections.swap(items, j, j + 1);
          }
        }
      }
      return items;
    }


    public static
    <T extends Comparable<T>> ArrayList<T> mergeSort(List<T> list) {
      int n = list.size();
      if (2 > n) {
        return (ArrayList<T>) list;
      }
      ArrayList<T> sorted = new ArrayList<>();
      ArrayList<T> part1 = mergeSort(list.subList(0, n / 2));
      ArrayList<T> part2 = mergeSort(list.subList((n / 2) + 1, n));
      while (!part1.isEmpty() && !part2.isEmpty()) {
        if (part1.get(0).compareTo(part2.get(0)) < 0) {
          sorted.add(part1.remove(0));
        } else {
          sorted.add(part2.remove(0));
        }
      }
      sorted.addAll(part1);
      sorted.addAll(part2);
      return sorted;
    }

    /**
     * @param items
     * @return
     */
    public static
    <T extends Comparable<T>> ArrayList<T> insertionSort(ArrayList<T> items) {
      int n = items.size();
      for (int i = 0; i < n; i++) {
        for (int j = i; j > 0; j--) {
          T i1 = items.get(j - 1);
          T i2 = items.get(j);
          if (i1.compareTo(i2) > 0) {
            Collections.swap(items, j - 1, j);
          }
        }
      }
      return items;
    }  /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
  }

  public static
  class ComplexNumber {

    double real;
    double imaginary;

    public
    ComplexNumber(double real, double imaginary) {
      this.real = real + 0.0;
      this.imaginary = imaginary;
    }

    @Override
    public
    int hashCode() {
      return Objects.hash(real, imaginary);
    }

    @Override
    public
    boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if ((o == null) || (getClass() != o.getClass())) {
        return false;
      }
      ComplexNumber that = (ComplexNumber) o;
      return (Double.compare(that.real, real) == 0) && (Double.compare(that.imaginary, imaginary)
          == 0);
    }

    @Override
    public
    String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      if (real != 0) {
        stringBuilder.append(real);
      }
      if (imaginary != 0) {
        stringBuilder.append((imaginary > 0) ? " + " : " - ").append(Math.abs(imaginary))
            .append("i");
      }
      if (stringBuilder.length() == 0) {
        stringBuilder.append(0);
      }
      return stringBuilder.toString();
    }
  }

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
  }

  public
  class CoinFlip {

    private int nCoinFlips;

    // flips a coin n times
    public
    CoinFlip(int nFlips) {
      nCoinFlips = nFlips;
      for (int i = 0; i < nFlips; i++) {
        flipACoin();
      }
    }

    // performs a coin flip and returns the result.
    CoinFace flipACoin() {
      double randomNumber = Math.random();
      if (randomNumber < 0.5) {
        return CoinFace.HEAD.toss();
      }
      /* else */
      return CoinFace.TAIL.toss();
    }

    // finds percentage of of heads out of the total coinflips
    public
    float percentageOfHeads() {
      float percentage = CoinFace.HEAD.frequency() / (float) nCoinFlips;
      return percentage * 100;
    }
  }
}
