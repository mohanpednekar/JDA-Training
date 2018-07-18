package com.jda.functionalprograms

import com.jda.utility.Utility
import java.util.*
import java.util.function.Consumer

object StringPermutations {
    @JvmStatic
    fun main(args: Array<String>) {
        val reader = Utility().Reader()
        Utility.printLine("Enter a string to permute")
        val string = reader.readString()

        val iteratedPermutations = iterativelyPermute(string)
        iteratedPermutations.forEach(Consumer<String> { println(it) })
        val recursivePermutations = recursivelyPermute(string)
        recursivePermutations.forEach(Consumer<String> { println(it) })
        println("The number of recursive permutations is " + recursivePermutations.size)
    }

    private fun iterativelyPermute(string: String): HashSet<String> {
        val permuted = HashSet<String>()

        val letters = string.toCharArray()
        val n = string.length
        for (i in 0 until n) {

        }
        return permuted
    }

    private fun recursivelyPermute(string: String): HashSet<String> {
        val n = string.length
        return recursivelyPermute(string, 0, n - 1)
    }

    private fun recursivelyPermute(string: String, left: Int, right: Int): HashSet<String> {
        val permuted = HashSet<String>()
        if (left == right) {
            permuted.add(string)
        } else {
            swapAndRecursivelyPermute(string, left, right, permuted)
        }
        return permuted
    }

    private fun swapAndRecursivelyPermute(string: String, left: Int, right: Int, permuted: HashSet<String>) {
        var string = string
        for (i in left..right) {
            string = swapped(string, i, left)
            permuted.addAll(recursivelyPermute(string, left + 1, right))
            string = swapped(string, i, left)
        }
    }

    private fun swapped(string: String, i: Int, j: Int): String {
        val letters = string.toCharArray()
        val temp = letters[i]
        letters[i] = letters[j]
        letters[j] = temp
        return String(letters)
    }
}
