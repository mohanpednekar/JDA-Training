/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 12, 2018
 */
package com.jda.algorithm_programs

import com.jda.utility.Util
import com.jda.utility.Utility

object FindMyNumber {

    /**
     * @param args
     */
    @JvmStatic
    fun main(args: Array<String>) {
        val N = Integer.parseInt(args[0])
        Utility.printLine("Think of a number between 0 and " + (N - 1))
        val n = Util.log2(N)
        val guessed = Util.guess(0, N - 1, n)
        if (guessed < 0) {
            println("I ran out of attempts :(")
        } else {
            println("Your number is $guessed")
        }
    }
}
