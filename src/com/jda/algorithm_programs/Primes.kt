/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 */
package com.jda.algorithm_programs

import com.jda.utility.Util
import java.util.function.Consumer

object Primes {

    /**
     * @param args
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val maxPrime = 1000
        val primes = Util.primesUpto(maxPrime)
        primes.forEach(Consumer<Int> { println(it) })
    }
}
