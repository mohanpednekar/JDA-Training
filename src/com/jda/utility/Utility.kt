/**********************************************************************
 * Purpose: Contains all the utilities used while writing programs for JDA
 * Traininig
 *
 * @author Mohan Pednekar
 * @version 4.0
 * @since 04-07-2018
 */

package com.jda.utility

import java.util.*

class Utility {

    // defines an enum for the only two possibilities of coin faces
    internal enum class CoinFace// initialises the frequency of the coinface
    (// stores the frequency of the corresponding coinface
            private var count: Int) {
        // head and tail initialised with zero frequency
        HEAD(0),
        TAIL(0);

        // returns the frequency of the corresponding coinface
        fun frequency(): Int {
            return count
        }

        // increments the frequency of the coinface when tossed and returns its
        // own instance for further use if needed
        fun toss(): CoinFace {
            count++
            return this
        }
    }

    enum class Result {
        WIN, LOSS
    }

    object Sorting {

        /**
         * Performs bubble sort
         */
        fun <T : Comparable<T>> bubbleSort(items: ArrayList<T>): ArrayList<T> {
            val n = items.size
            for (i in 0 until n - 1) {
                for (j in 0 until n - 1) {
                    val input = items[j]
                    val input2 = items[j + 1]
                    if (input.compareTo(input2) > 0) {
                        Collections.swap(items, j, j + 1)
                    }
                }
            }
            return items
        }

        //    static
        //    <T> int compare(T t, T t2) {
        //      if (t.getClass().toString().endsWith("Integer")) {
        //        return ((Integer) t).compareTo((Integer) t2);
        //      }
        //      if (t.getClass().toString().endsWith("String")) {
        //        return ((String) t).compareToIgnoreCase((String) t2);
        //      }
        //      return 0;
        //    }

        fun <T : Comparable<T>> mergeSort(list: List<T>): ArrayList<T> {
            val n = list.size
            if (2 > n) {
                return list as ArrayList<T>
            }
            val sorted = ArrayList<T>()
            val part1 = mergeSort(list.subList(0, n / 2))
            val part2 = mergeSort(list.subList(n / 2 + 1, n))
            while (!part1.isEmpty() && !part2.isEmpty()) {
                if (part1[0] < part2[0]) {
                    sorted.add(part1.removeAt(0))
                } else {
                    sorted.add(part2.removeAt(0))
                }
            }
            sorted.addAll(part1)
            sorted.addAll(part2)
            return sorted
        }

        /**
         * @param items
         * @return
         */
        fun <T : Comparable<T>> insertionSort(items: ArrayList<T>): ArrayList<T> {
            val n = items.size
            for (i in 0 until n) {
                for (j in i downTo 1) {
                    val i1 = items[j - 1]
                    val i2 = items[j]
                    if (i1.compareTo(i2) > 0) {
                        Collections.swap(items, j - 1, j)
                    }
                }
            }
            return items
        }  /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    }

    class ComplexNumber(real: Double, internal var imaginary: Double) {

        internal var real: Double = 0.toDouble()

        init {
            this.real = real + 0.0
        }

        override fun hashCode(): Int {
            return Objects.hash(real, imaginary)
        }

        override fun equals(o: Any?): Boolean {
            if (this === o) {
                return true
            }
            if (o == null || javaClass != o.javaClass) {
                return false
            }
            val that = o as ComplexNumber?
            return java.lang.Double.compare(that!!.real, real) == 0 && java.lang.Double.compare(that.imaginary, imaginary) == 0
        }

        override fun toString(): String {
            val stringBuilder = StringBuilder()
            if (real != 0.0) {
                stringBuilder.append(real)
            }
            if (imaginary != 0.0) {
                stringBuilder.append(if (imaginary > 0) " + " else " - ").append(Math.abs(imaginary)).append("i")
            }
            if (stringBuilder.length == 0) {
                stringBuilder.append(0)
            }
            return stringBuilder.toString()
        }
    }

    inner class Reader {

        private val scanner: Scanner

        init {
            scanner = Scanner(System.`in`)
        }

        fun readDouble(): Double {
            return scanner.nextDouble()
        }

        /**
         * @param positive
         * @param negative
         * @return
         */
        fun readBoolean(positive: String, negative: String): Boolean {
            return scanner.next().toLowerCase().startsWith(positive)
        }

        // reads an integer from input stream
        fun readInteger(): Int {
            return scanner.nextInt()
        }

        fun readIntegerArray(size: Int): IntArray {
            val array = IntArray(size)
            for (i in 0 until size) {
                array[i] = scanner.nextInt()
            }
            return array
        }

        fun readIntegerArray(rows: Int, columns: Int): Array<IntArray> {
            val array = Array(rows) { IntArray(columns) }
            for (i in 0 until rows) {
                for (j in 0 until columns) {
                    array[i][j] = scanner.nextInt()
                }
            }
            return array
        }

        /*
     * // reads a line from input stream delimited by newline characters public
     * String readLine() { return scanner.nextLine(); } // reads a real number
     * (double) from input stream public double readReal() { return
     * scanner.nextDouble(); }
     */
        // reads a string from input stream delimited by any whitespace
        fun readString(): String {
            return scanner.next()
        }
    }

    inner class CoinFlip// flips a coin n times
    (private val nCoinFlips: Int) {

        init {
            for (i in 0 until nCoinFlips) {
                flipACoin()
            }
        }

        // performs a coin flip and returns the result.
        internal fun flipACoin(): CoinFace {
            val randomNumber = Math.random()
            return if (randomNumber < 0.5) {
                CoinFace.HEAD.toss()
            } else CoinFace.TAIL.toss()
            /* else */
        }

        // finds percentage of of heads out of the total coinflips
        fun percentageOfHeads(): Float {
            val percentage = CoinFace.HEAD.frequency() / nCoinFlips.toFloat()
            return percentage * 100
        }
    }

    companion object {

        fun findRoots(a: Double, b: Double, c: Double): HashSet<ComplexNumber> {
            val roots = HashSet<ComplexNumber>()
            val d = discriminant(a, b, c) //or delta
            val real = -b / (2 * a)
            println(real)

            val img = Math.sqrt(Math.abs(d)) / (2 * a)
            println(img)
            if (d < 0) {
                roots.add(ComplexNumber(real, img))
                roots.add(ComplexNumber(real, -img))
            } else {
                roots.add(ComplexNumber(real + img, 0.0))
                roots.add(ComplexNumber(real - img, 0.0))
            }

            return roots
        }

        private fun discriminant(a: Double, b: Double, c: Double): Double {
            return b * b - 4.0 * a * c
        }

        fun euclideanDistance(x1: Double, y1: Double, x2: Double, y2: Double): Double {
            val dx = x1 - x2
            val dy = y1 - y2
            return Math.sqrt(Math.pow(dx, 2.0) + Math.pow(dy, 2.0))
        }

        fun factorial(length: Int): Int {
            return if (length == 0) {
                1
            } else length * factorial(length - 1)
        }

        fun <T> printArray(array: Array<Array<T>>, rows: Int, columns: Int) {
            for (i in 0 until rows) {
                for (j in 0 until columns) {
                    print(array[i][j])
                }
                println()
            }
            // TODO print
        }

        // checks whether the number of arguments is n
        fun checkCmdArgs(args: Array<String>, n: Int): Boolean {
            if (args.size < n) {
                println("Too few arguments. Please provide  " + n + " argument" + if (n > 1) "s" else "")
            }
            if (args.size > n) {
                println("Too many arguments. Please provide  " + n + " argument" + if (n > 1) "s" else "")
            }
            return args.size == n
        }

        /**
         * @param stake the amount at stake each day
         * @param goal the desired winning amount each day
         * @param bet the amount betted per play
         * @return whether the goal amount was won or lost
         */
        fun gamble(stake: Int, goal: Int, bet: Int): Result {
            var balance = stake
            val coinFlip = Utility().CoinFlip(0)
            while (true) {
                if (coinFlip.flipACoin() == CoinFace.HEAD) {
                    balance += bet
                } else {
                    balance -= bet
                }
                if (balance >= goal) {
                    return Result.WIN
                }
                if (balance <= 0) {
                    return Result.LOSS
                }
            }
        }

        /**
         * @param n the order of Harmonic number desired
         * @return the nth harmonic number
         */
        fun harmonicNumber(n: Int): Double {

            var result = 0.0
            for (i in 1..n) {
                result += 1.0 / i
            }
            return result
        }

        // checks whether the year provided is leap year or not
        fun isLeapYear(year: Int): Boolean {
            if (year % 4 != 0) {
                return false // year not divisible by 4 is not leap
            }
            return if (year % 400 == 0) {
                true // year divisible by 400 is leap
            } else year % 100 != 0
        }

        // appends an ordinal suffix to the number
        fun ordinal(n: Int): String {
            if (n % 100 > 10 && n % 100 < 20) {
                return n.toString() + "th"
            }
            when (n % 10) {
                1 -> return n.toString() + "st"
                2 -> return n.toString() + "nd"
                3 -> return n.toString() + "rd"
                else -> return n.toString() + "th"
            }
        }

        // calculates x^n for non-negative n;
        fun power(x: Int, n: Int): Int {
            var result = 1
            for (i in 0 until n) {
                result *= x
            }
            return result
        }

        // finds the smallest prime factor of the number n
        fun primeFactor(n: Int): Int {
            var i = 2
            while (i * i <= n) {
                if (n % i == 0) {
                    return i
                }
                i++
            }
            return n
        }

        fun print(string: String) {
            print(string)
        }

        fun printLine(string: String) {
            println(string)
        }

        // converts a string into positive integer if possible, otherwise returns -1
        fun stringToPositiveInteger(string: String): Int {
            val n: Int
            try {
                n = Integer.parseInt(string)
                if (n >= 0) {
                    return n
                }
            } catch (e: NumberFormatException) {
                // invoked only when parsing an integer fails
                println("The value given is not an integer")
                return -1
            }

            // when n is negative
            println("The value given is not a positive integer")
            return -1
        }

        fun toString(collection: Collection<Int>): String {
            val sb = StringBuilder()
            collection.forEach { item -> sb.append(item).append(" ") }
            return sb.toString()
        }
    }
}
