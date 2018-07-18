/************************************************************
 *
 * Purpose: Flip a coin and find percentage of Heads and Tails
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since 04-07-2018
 *
 */

package com.jda.functionalprograms

import com.jda.utility.Utility

object CoinFlipping {

    @JvmStatic
    fun main(args: Array<String>) {

        val reader = Utility().Reader()
        Utility.printLine("How many times do you want to flip coin?")

        // nCoinFlips  is the number of times the coin is to be flipped
        val nCoinFlips = reader.readInteger()

        //	run the experiment of flipping coin n times
        val experiment = Utility().CoinFlip(nCoinFlips)

        //	find the percentage of Heads in the experiment
        val percentageHeads = experiment.percentageOfHeads()

        //	print result
        //	the percentage of tails is (100- percentage of heads)
        Utility.printLine("You flipped heads " + percentageHeads + "% times and tails " + (100 - percentageHeads) + " times.")
    }
}
