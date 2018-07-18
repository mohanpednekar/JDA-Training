package com.jda.functionalprograms

import com.jda.utility.Utility

object LeapYear {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.print("Enter the year : ")
        var year = reader.readInteger()
        while (year < 1000 || year > 9999) {
            Utility.print("Year must be 4 digit.\nEnter the year: ")
            year = reader.readInteger()
        }
        if (Utility.isLeapYear(year)) {
            Utility.printLine("It is a leap year")
        } else {
            Utility.printLine("It is not a leap year")
        }
    }
}
