package com.jda.functionalprograms

import com.jda.utility.Utility

object ZeroSumTriples {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.printLine("How many integers do you want to read?")
        val n = reader.readInteger()
        Utility.printLine("Enter $n integers")
        val array = reader.readIntegerArray(n)
        val count = findZeroSumTriples(array)
        Utility.printLine("There are $count zero sum triples")
    }

    private fun findZeroSumTriples(array: IntArray): Int {
        val n = array.size
        var count = 0
        for (i in 0 until n - 2) {
            for (j in i + 1 until n - 1) {
                for (k in j + 1 until n) {
                    if (array[i] + array[j] + array[k] == 0) {
                        count++
                        println(array[i].toString() + " " + array[j] + " " + array[k])
                    }
                }
            }
        }
        return count
    }
}
