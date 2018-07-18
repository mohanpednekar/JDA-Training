package com.jda.algorithm_programs

import com.jda.utility.Utility
import java.util.*

object VendingMachine {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        println("Enter the denominations available in your currency followed by 0")
        val denominations = HashSet<Int>()
        while (true) {
            val denomination = reader.readInteger()
            if (denomination == 0) {
                break
            }
            denominations.add(denomination)
        }
        println("Enter the amount you want to be disbursed")
    }
}
