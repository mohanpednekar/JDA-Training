package com.jda.algorithm_programs

import com.jda.utility.Util
import com.jda.utility.Util.TemperatureUnit
import com.jda.utility.Utility

object TemperatureConversion {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()

        println("Let's convert temperature")

        println("Enter temperature in degree Celcius")
        val tempCelcius1 = reader.readDouble()
        val tempFahrenheit1 = Util.temperatureConversion(tempCelcius1, TemperatureUnit.Fahrenheit)
        println("The temperature in degree Fahrenheit is $tempFahrenheit1")

        println("\nEnter temperature in degree Fahrenheit")
        val tempFaahrenheit2 = reader.readDouble()
        val tempCelcius2 = Util.temperatureConversion(tempFaahrenheit2, TemperatureUnit.Celsius)
        println("The temperature in degree Celcius is $tempCelcius2")
    }
}
