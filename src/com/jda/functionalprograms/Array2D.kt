package com.jda.functionalprograms

import com.jda.utility.Utility

object Array2D {

    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.printLine("Let's create a 2D array.")
        Utility.printLine("Enter the number of rows")
        val rows = reader.readInteger()
        Utility.printLine("Enter the number of columns.")
        val columns = reader.readInteger()

        Utility.printLine("Enter the array")
        val array = reader.readIntegerArray(rows, columns)
        val objArray = getIntegers(rows, columns, array)
        Utility.printLine("The array you input is as follows.")
        Utility.printArray(objArray, rows, columns)
    }

    private fun getIntegers(rows: Int, columns: Int, array: Array<IntArray>): Array<Array<Int?>> {
        val objArray = Array(rows) { arrayOfNulls<Int>(columns) }
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                objArray[i][j] = array[i][j]
            }
        }
        return objArray
    }
}
