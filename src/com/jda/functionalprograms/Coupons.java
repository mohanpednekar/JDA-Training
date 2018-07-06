package com.jda.functionalprograms;

import com.jda.utility.Utility;

import java.util.HashSet;
import java.util.Random;

public
class Coupons {

	public static
	void main(String[] args) {
		int MAX_COUPONS = 1000;

		Utility utility = new Utility();
		utility.printLine("Welcome to Lotto mania!");
		utility.printLine("How many coupons do you want to generate?");
		int nCoupons = utility.readInteger();
		HashSet<Integer> couponSet = new HashSet<>();
		while (couponSet.size() < nCoupons) couponSet.add(randomNumber(MAX_COUPONS));

		utility.printLine("Your coupons are " + utility.toStringBuilder(couponSet));

		int attempts = attemptsToProcessDistinctCoupons(couponSet, MAX_COUPONS);

		utility.printLine("All coupons generated in " + attempts + " attempts.");

	}

	/**
	 * @param couponSet   the original set of coupons targeted
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

	private static
	Integer randomNumber(int maxCoupons) {
		Random random = new Random();
		return random.nextInt(maxCoupons);
	}
}
