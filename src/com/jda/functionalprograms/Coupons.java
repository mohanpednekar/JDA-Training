package com.jda.functionalprograms;

import com.jda.utility.Utility;
import com.jda.utility.Utility.Reader;
import java.util.HashSet;
import java.util.Random;

public
class Coupons {

  public static
  void main(String[] args) {
    int MAX_COUPONS;

    Reader reader = new Utility().new Reader();
    Utility.printLine("Welcome to Lotto mania!");

    Utility.printLine("How many coupons do you want to generate?");
    int nCoupons = reader.readInteger();
    MAX_COUPONS = nCoupons;
    HashSet<Integer> couponSet = new HashSet<>();
    while (couponSet.size() < nCoupons) {
      couponSet.add(randomNumber(MAX_COUPONS));
    }

    Utility.printLine("Your coupons are " + Utility.toString(couponSet));

    int attempts = attemptsToProcessDistinctCoupons(couponSet, MAX_COUPONS);

    Utility.printLine("All coupons generated in " + attempts + " attempts.");
  }

  private static
  Integer randomNumber(int maxCoupons) {
    Random random = new Random();
    return random.nextInt(maxCoupons);
  }

  /**
   * @param couponSet the original set of coupons targeted
   * @param max_coupons maximum number of coupons
   * @return the number of attempts made to generate all the target coupons
   */
  private static
  int attemptsToProcessDistinctCoupons(HashSet<Integer> couponSet, int max_coupons) {
    HashSet<Integer> candidateLot = new HashSet<>();
    int attempts = 0;
    while (!candidateLot.containsAll(couponSet)) {
      candidateLot.add(randomNumber(max_coupons));
      attempts++;
    }
    return attempts;
  }
}
