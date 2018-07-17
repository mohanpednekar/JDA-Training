/*******************************************************************
 * Purpose: Contains all utilities for Algorithm programs
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 *******************************************************************/
package com.jda.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public
class Util {

  /**
   * checks whether the given strings can be formed by rearranging the letters in each other
   */

  public static
  boolean areAnagrams(String string1, String string2) {
    List<Character> s1 = stringToCharacterList(string1);
    List<Character> s2 = stringToCharacterList(string2);
    Collections.sort(s1);
    Collections.sort(s2);
    return s1.equals(s2);
  }

  /**
   * @return list of all the characters (in lowercase) present in the string excluding whitespace
   */
  private static
  List<Character> stringToCharacterList(String string1) {
    return string1.replaceAll("\\s", "").toLowerCase().chars().mapToObj(c -> (char) c)
        .collect(Collectors.toList());
  }

  public static
  int guess(int low, int high, int n) {
    if (low == high) {
      return low;
    }
    System.out.println(n + " attempt" + (1 < n ? "s" : "") + " left");
    if (0 == n) {
      return -1;
    }
    int mid = (high + low) / 2;
    StringBuilder query = new StringBuilder();
    query.append("Is the number ");
    if (low != mid) {
      query.append("between ");
    }
    query.append(low);
    if (low != mid) {
      query.append(" and ").append(mid);
    }
    query.append("?");
    System.out.println(query);
    Utility utility = new Utility();
    boolean correctGuess = utility.readBoolean("y", "n");
    return correctGuess ? guess(low, mid, n - 1) : guess(mid + 1, high, n - 1);
  }

  public static
  boolean isPalindrome(String string) {
    String original = string.replace("\\s", "").toLowerCase();
    String reversed = new StringBuilder(original).reverse().toString();
    return original.equals(reversed);
  }

  /**
   * @param n
   * @return
   */
  public static
  int log2(int n) {
    return 32 - Integer.numberOfLeadingZeros(n);
  }

  public static
  double temperatureConversion(double inputTemp, TemperatureUnit convertTo) {
    double outputTemp = Double.NaN;
    switch (convertTo) {
      case Celsius:
        outputTemp = (inputTemp - 32.0) * (5.0 / 9.0);
        break;
      case Fahrenheit:
        outputTemp = (inputTemp * (9.0 / 5.0)) + 32.0;
        break;
    }
    return outputTemp;
  }

  public static
  WeekDay dayOfWeek(int m, int d, int y) {
    int y0 = y - ((14 - m) / 12);
    int x = ((y0 + (y0 / 4)) - (y0 / 100)) + (y0 / 400);
    int m0 = (m + (12 * ((14 - m) / 12))) - 2;
    int d0 = (d + x + ((31 * m0) / 12)) % 7;
    return WeekDay.values()[d0];
  }

  public static
  double sqrt(double number) {
    double EPSILON = 1e-15;
    double root;
    do {
      root = number;
      root = average(number / root, root);
    } while (Math.abs(root - (number / root)) > (EPSILON * root));
    return root;
  }

  /**
   * @param maxPrime the limit for the largest prime number to find
   * @return list of all prime numbers upto maxPrime
   */
  public static
  ArrayList<Integer> primesUpto(int maxPrime) {
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i = 2; i <= maxPrime; i++) {
      nums.add(i);
    }
    ArrayList<Integer> primes = new ArrayList<>();
    while (!nums.isEmpty()) {
      Integer nextPrime = nums.remove(0);
      primes.add(nextPrime);
      nums.removeIf(n -> 0 == (n % nextPrime));
    }
    return primes;
  }

  public static
  double monthlyPayment(double principal, double years, double rateOfInterest) {
    double p = principal;
    double n = 12 * years;
    double r = rateOfInterest / (12 * 100);
    return (p * r) / (1 - Math.pow(1 + r, -n));
  }

  public
  enum WeekDay {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
  }

  private static
  double average(double n1, double n2) {
    return (n1 + n2) / 2;
  }

  public static
  String toBinary(int decimal) {
    StringBuilder binary = new StringBuilder();
    int padding = 32;
    while (0 < decimal) {
      binary.append(decimal % 2);
      decimal /= 2;
      padding--;
    }
    for (int i = 0; i < padding; i++) {
      binary.append(0);
    }
    return binary.reverse().toString();
  }

  public static
  String swapNibbles(String binary) {
    int paddingNeeded = binary.length() % 8;
    StringBuilder input = new StringBuilder();
    for (int i = 0; i < paddingNeeded; i++) {
      input.append(0);
    }
    input.append(binary);

    StringBuilder output = new StringBuilder();

    while (0 < input.length()) {
      output.append(input.substring(4, 8)).append(input.substring(0, 4));
      input.delete(0, 8);
    }
    return output.toString();
  }


  public
  enum TemperatureUnit {
    Celsius, Fahrenheit
  }

  public static
  class Stopwatch {

    private long begin;
    private long end;

    private long elapsedTime;

    public
    Stopwatch() {
      begin = 0;
      end = 0;
      elapsedTime = 0;
    }

    public
    double elapsedTimeSeconds() {
      return elapsedTimeNanos() * 1e-9;
    }

    public
    long elapsedTimeNanos() {
      return elapsedTime;
    }

    public
    void start() {
      begin = System.nanoTime();
    }

    public
    void stop() {
      end = System.nanoTime();
      elapsedTime = end - begin;
    }
  }
}
