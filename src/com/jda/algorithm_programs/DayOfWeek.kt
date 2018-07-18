package com.jda.algorithm_programs

import com.jda.utility.Util
import com.jda.utility.Utility

object DayOfWeek {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Enter date in \"mm dd yyyy\" format")
        val reader = Utility().Reader()
        val mm = reader.readInteger()
        val dd = reader.readInteger()
        val yyyy = reader.readInteger()
        println(Util.dayOfWeek(mm, dd, yyyy))
    }
}
