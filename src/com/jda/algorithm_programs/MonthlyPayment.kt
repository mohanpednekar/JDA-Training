package com.jda.algorithm_programs

import com.jda.utility.Util

object MonthlyPayment {

    @JvmStatic
    fun main(args: Array<String>) {
        val p = java.lang.Double.parseDouble(args[0])
        val y = java.lang.Double.parseDouble(args[1])
        val r = java.lang.Double.parseDouble(args[2])

        println(Util.monthlyPayment(p, y, r))
    }
}
