package com.jda.functionalprograms

import com.jda.utility.Utility
import com.jda.utility.Utility.Result

object Gambler {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.printLine("Welcome to Casino Royale!")
        Utility.printLine("How much do you want to stake each day?")
        val stake = reader.readInteger()
        Utility.printLine("How much do you want to win each day?")
        val goal = reader.readInteger()
        Utility.printLine("How many times do you want to gamble?")
        val attempts = reader.readInteger()

        val bet = 1      //  bet is $1 per play
        var wins = 0     //  number of winning days
        var losses = 0   //  number of losing days

        // attempt the gambling game for given number of days
        for (i in 0 until attempts) {
            if (Utility.gamble(stake, goal, bet) == Result.WIN) {
                wins++
            } else {
                losses++
            }
        }

        Utility.printLine("You won $wins times and lost $losses times")
        Utility.printLine("You won " + wins * 100.0 / attempts + "% times")
    }
}
