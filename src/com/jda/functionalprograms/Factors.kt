/*******************************************************************
 * Purpose: To find prime factors of a number
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 */
package com.jda.functionalprograms

import com.jda.utility.Utility
import java.util.*

object Factors {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.printLine("Enter a number to factorise")
        val n = reader.readInteger()

        val factors = ArrayList<Int>()
        var temp = n
        while (temp > 1) {
            val f = Utility.primeFactor(temp)
            factors.add(f)
            temp = temp / f
        }

        Utility.printLine("The prime factors of " + n + " are " + Utility.toString(factors))
    }
}
