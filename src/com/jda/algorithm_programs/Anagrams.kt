/*******************************************************************
 * Purpose: to check whether two strings are nagrams of each other
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 */
package com.jda.algorithm_programs

import com.jda.utility.Util
import com.jda.utility.Utility

object Anagrams {
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        println("Enter first string")

        val string1 = reader.readString()

        println("Enter second string")

        val string2 = reader.readString()

        if (Util.areAnagrams(string1, string2)) {
            println("Anagrams")
        } else {
            println("Not Anagrams")
        }
    }
}
