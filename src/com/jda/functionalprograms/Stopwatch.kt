package com.jda.functionalprograms

import com.jda.utility.Utility

object Stopwatch {
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        val start = System.currentTimeMillis()
        doNothing(10e7)
        val end = System.currentTimeMillis()
        Utility.printLine("Watch started at $start")
        Utility.printLine("Watch stopped at $end")
        Utility.printLine("The time elapsed was " + (end - start) + " ms")
    }

    //  This function does nothing
    //  Actually, it prints nothing n times
    private fun doNothing(n: Double) {
        var i = 0
        while (i < n) {
            print("")
            i++
        }
    }
}
