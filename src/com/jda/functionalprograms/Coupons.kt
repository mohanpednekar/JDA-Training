package com.jda.functionalprograms

import com.jda.utility.Utility
import java.util.*

object Coupons {

    @JvmStatic
    fun main(args: Array<String>) {
        val MAX_COUPONS: Int

        val reader = Utility().Reader()
        Utility.printLine("Welcome to Lotto mania!")

        Utility.printLine("How many coupons do you want to generate?")
        val nCoupons = reader.readInteger()
        MAX_COUPONS = nCoupons
        val couponSet = HashSet<Int>()
        while (couponSet.size < nCoupons) {
            couponSet.add(randomNumber(MAX_COUPONS))
        }

        Utility.printLine("Your coupons are " + Utility.toString(couponSet))

        val attempts = attemptsToProcessDistinctCoupons(couponSet, MAX_COUPONS)

        Utility.printLine("All coupons generated in $attempts attempts.")
    }

    private fun randomNumber(maxCoupons: Int): Int {
        val random = Random()
        return random.nextInt(maxCoupons)
    }

    /**
     * @param couponSet the original set of coupons targeted
     * @param max_coupons maximum number of coupons
     * @return the number of attempts made to generate all the target coupons
     */
    private fun attemptsToProcessDistinctCoupons(couponSet: HashSet<Int>, max_coupons: Int): Int {
        val candidateLot = HashSet<Int>()
        var attempts = 0
        while (!candidateLot.containsAll(couponSet)) {
            candidateLot.add(randomNumber(max_coupons))
            attempts++
        }
        return attempts
    }
}
