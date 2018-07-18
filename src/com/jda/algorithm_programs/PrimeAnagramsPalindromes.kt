/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 */
package com.jda.algorithm_programs

import com.jda.utility.Util

object PrimeAnagramsPalindromes {

    /**
     * @param args
     */
    @JvmStatic
    fun main(args: Array<String>) {
        // TODO Auto-generated method stub
        val maxPrime = 1000
        val primes = Util.primesUpto(maxPrime)
        primes.forEach { prime -> if (Util.isPalindrome(prime.toString())) print(prime.toString() + " \t") }
        println()
        for (prime1 in primes) for (prime2 in primes) {
            if (prime1 >= prime2) continue
            if (Util.areAnagrams(prime1.toString(), prime2.toString())) print(prime1.toString() + " and " + prime2 + " \t")
        }
    }
}
