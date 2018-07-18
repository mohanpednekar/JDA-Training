/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 11, 2018
 */
package com.jda.algorithm_programs

import com.jda.utility.Util.Stopwatch
import com.jda.utility.Utility
import com.jda.utility.Utility.Sorting
import java.util.*
import java.util.function.Consumer

class SearchAndSort {

    /**
     * @param items
     */
    private fun <T : Comparable<T>> searchAndSort(items: ArrayList<T>, itemToSearch: T) {

        Watcher.BINARY.start()
        val found = binarySearch(items, itemToSearch)
        Watcher.BINARY.stop()
        println("found = $found")

        Watcher.INSERTION.start()
        val insertionSorted = Sorting.insertionSort(items)
        Watcher.INSERTION.stop()
        println(insertionSorted)

        Watcher.BUBBLE.start()
        val bubbleSorted = Sorting.bubbleSort(items)
        Watcher.BUBBLE.stop()
        println(bubbleSorted)

        val watchersMap = HashMap<Watcher, Long>()

        for (watcher in Watcher.values()) {
            println(watcher.resultString())
            watchersMap[watcher] = watcher.elapsedTimeNanos()
        }
    }

    /**
     * @param items
     * @param itemToSearch
     * @return
     */
    fun <T : Comparable<T>> binarySearch(items: ArrayList<T>, itemToSearch: T): Boolean {
        val tree = BST(items[0])
        items.forEach(Consumer<T> { tree.insert(it) })
        return tree.has(itemToSearch)
    }

    internal enum class Watcher(var watcherName: String) {
        BINARY("Binary search"), INSERTION("Insertion sort"), BUBBLE("Bubble sort");

        var stopwatch = Stopwatch()

        fun start() {
            stopwatch.start()
        }

        fun stop() {
            stopwatch.stop()
        }

        fun elapsedTimeNanos(): Long {
            return stopwatch.elapsedTimeNanos()
        }

        fun resultString(): String {
            return watcherName + " took " + elapsedTimeSeconds() + " seconds"
        }

        fun elapsedTimeSeconds(): Double {
            return stopwatch.elapsedTimeSeconds()
        }
    }

    class BST<T : Comparable<T>> internal constructor(private var value: T) {
        private var left: BST<T>? = null
        private var right: BST<T>? = null

        /*
     * (non-Javadoc)
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
        //    @Override
        //    public
        //    int compare(T o1, T o2) {
        //      if (o1.getClass().toString().endsWith("Integer")) {
        //        return ((Integer) o1).compareTo((Integer) o2);
        //      }
        //      if (o1.getClass().toString().endsWith("String")) {
        //        return ((String) o1).compareToIgnoreCase((String) o2);
        //      }
        //      return 0;
        //    }
        fun has(value: T): Boolean {
            if (value.compareTo(this.value) == 0) {
                return true
            }
            if (value.compareTo(this.value) < 0 && null != left) {
                return left!!.has(value)
            }
            return if (value.compareTo(this.value) > 0 && null != right) {
                right!!.has(value)
            } else false
        }

        fun insert(value: T) {
            if (value.compareTo(this.value) <= 0) {
                if (null == left) {
                    left = BST(value)
                } else {
                    left!!.insert(value)
                }
            } else if (null == right) {
                right = BST(value)
            } else {
                right!!.insert(value)
            }
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val reader = Utility().Reader()
            val programs = SearchAndSort()
            Utility.printLine("What do you want to enter?")
            Utility.printLine("s : Strings \t i : Integers")
            val ch = reader.readString().toLowerCase().get(0)
            Utility.printLine("How many of them?")
            val n = reader.readInteger()

            when (ch) {
                's' -> {
                    val strings = ArrayList<String>()
                    Utility.printLine("Enter $n strings")

                    for (i in 0 until n) {
                        strings.add(reader.readString())
                    }
                    Utility.printLine("What do you want to search for?")
                    val stringToSearch = reader.readString()
                    programs.searchAndSort(strings, stringToSearch)
                }
                'i' -> {
                    val integers = ArrayList<Int>()
                    Utility.printLine("Enter $n integers")
                    for (i in 0 until n) {
                        integers.add(reader.readInteger())
                    }
                    Utility.printLine("What do you want to search for?")
                    val integerToSearch = reader.readInteger()
                    programs.searchAndSort(integers, integerToSearch)
                }
            }
        }
    }
}
