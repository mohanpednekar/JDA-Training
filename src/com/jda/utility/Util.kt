/*******************************************************************
 * Purpose: Contains all utilities for Algorithm programs
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 9, 2018
 */
package com.jda.utility

import java.util.*
import java.util.stream.Collectors

object Util {

    fun notesNeededToMake(money: Int, denominations: HashSet<Int>): ArrayList<Int> {
        val sortedDenominations = TreeSet<Int>()
        sortedDenominations.addAll(denominations)
        val notes = ArrayList<Int>()
        while (money > 0) {
            val note = sortedDenominations.last()
        }

        return notes
    }

    /**
     * checks whether the given strings can be formed by rearranging the letters in each other
     */
    fun areAnagrams(string1: String, string2: String): Boolean {
        val s1 = stringToCharacterList(string1)
        val s2 = stringToCharacterList(string2)
        Collections.sort(s1)
        Collections.sort(s2)
        return s1 == s2
    }

    /**
     * @return list of all the characters (in lowercase) present in the string excluding whitespace
     */
    private fun stringToCharacterList(string1: String): List<Char> {
        return string1.replace("\\s".toRegex(), "").toLowerCase().chars().mapToObj({ c -> c.toChar() }).collect(Collectors.toList<Char>())
    }

    fun guess(low: Int, high: Int, n: Int): Int {
        if (low == high) {
            return low
        }
        println(n.toString() + " attempt" + (if (1 < n) "s" else "") + " left")
        if (0 == n) {
            return -1
        }
        val mid = (high + low) / 2
        val query = StringBuilder()
        query.append("Is the number ")
        if (low != mid) {
            query.append("between ")
        }
        query.append(low)
        if (low != mid) {
            query.append(" and ").append(mid)
        }
        query.append("?")
        println(query)
        val reader = Utility().Reader()
        val correctGuess = reader.readBoolean("y", "n")
        return if (correctGuess) guess(low, mid, n - 1) else guess(mid + 1, high, n - 1)
    }

    fun isPalindrome(string: String): Boolean {
        val original = string.replace("\\s", "").toLowerCase()
        val reversed = StringBuilder(original).reverse().toString()
        return original == reversed
    }

    /**
     * @param n
     * @return
     */
    fun log2(n: Int): Int {
        return 32 - Integer.numberOfLeadingZeros(n)
    }

    fun temperatureConversion(inputTemp: Double, convertTo: TemperatureUnit): Double {
        var outputTemp = java.lang.Double.NaN
        when (convertTo) {
            Util.TemperatureUnit.Celsius -> outputTemp = (inputTemp - 32.0) * (5.0 / 9.0)
            Util.TemperatureUnit.Fahrenheit -> outputTemp = inputTemp * (9.0 / 5.0) + 32.0
        }
        return outputTemp
    }

    fun dayOfWeek(m: Int, d: Int, y: Int): WeekDay {
        val y0 = y - (14 - m) / 12
        val x = y0 + y0 / 4 - y0 / 100 + y0 / 400
        val m0 = m + 12 * ((14 - m) / 12) - 2
        val d0 = (d + x + 31 * m0 / 12) % 7
        return WeekDay.values()[d0]
    }

    fun sqrt(number: Double): Double {
        val EPSILON = 1e-15
        var root: Double
        do {
            root = number
            root = average(number / root, root)
        } while (Math.abs(root - number / root) > EPSILON * root)
        return root
    }

    /**
     * @param maxPrime the limit for the largest prime number to find
     * @return list of all prime numbers upto maxPrime
     */
    fun primesUpto(maxPrime: Int): ArrayList<Int> {
        val nums = ArrayList<Int>()
        for (i in 2..maxPrime) {
            nums.add(i)
        }
        val primes = ArrayList<Int>()
        while (!nums.isEmpty()) {
            val nextPrime = nums.removeAt(0)
            primes.add(nextPrime)
            nums.removeIf { n -> 0 == n % nextPrime }
        }
        return primes
    }

    fun monthlyPayment(principal: Double, years: Double, rateOfInterest: Double): Double {
        val n = 12 * years
        val r = rateOfInterest / (12 * 100)
        return principal * r / (1 - Math.pow(1 + r, -n))
    }

    enum class WeekDay {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    private fun average(n1: Double, n2: Double): Double {
        return (n1 + n2) / 2
    }

    fun toBinary(decimal: Int): String {
        var decimal = decimal
        val binary = StringBuilder()
        var padding = 32
        while (0 < decimal) {
            binary.append(decimal % 2)
            decimal /= 2
            padding--
        }
        for (i in 0 until padding) {
            binary.append(0)
        }
        return binary.reverse().toString()
    }

    fun swapNibbles(binary: String): String {
        val paddingNeeded = binary.length % 8
        val input = StringBuilder()
        for (i in 0 until paddingNeeded) {
            input.append(0)
        }
        input.append(binary)

        val output = StringBuilder()

        while (0 < input.length) {
            output.append(input.substring(4, 8)).append(input.substring(0, 4))
            input.delete(0, 8)
        }
        return output.toString()
    }

    enum class TemperatureUnit {
        Celsius, Fahrenheit
    }

    class Stopwatch {

        private var begin: Long = 0
        private var end: Long = 0

        private var elapsedTime: Long = 0

        init {
            begin = 0
            end = 0
            elapsedTime = 0
        }

        fun elapsedTimeSeconds(): Double {
            return elapsedTimeNanos() * 1e-9
        }

        fun elapsedTimeNanos(): Long {
            return elapsedTime
        }

        fun start() {
            begin = System.nanoTime()
        }

        fun stop() {
            end = System.nanoTime()
            elapsedTime = end - begin
        }
    }
}
