/*******************************************************************
 * Purpose: Find the Nth harmonic number;
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 5, 2018
 */

package com.jda.functionalprograms

import com.jda.utility.Utility

object HarmonicNumber {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.printLine("Which harmonic number do you wath to find?")
        val n = reader.readInteger()
        if (n < 1) {
            Utility.printLine("Enter a positive number")
        }
        val result = Utility.harmonicNumber(n)
        Utility.printLine("The " + Utility.ordinal(n) + " harmonic number is " + result)
    }
}
