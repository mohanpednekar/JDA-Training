package com.jda.functionalprograms

import com.jda.utility.Utility
import com.jda.utility.Utility.ComplexNumber
import java.util.function.Consumer

object Quadratic {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Let's find the roots of a Quadratic equation a*x*x + b*x + c = 0")
        val reader = Utility().Reader()
        println("Please enter a b c")
        val a = reader.readDouble()
        val b = reader.readDouble()
        val c = reader.readDouble()
        val roots = Utility.findRoots(a, b, c)
        println(if (roots.size > 1) "The roots are " else "The root is ")
        roots.forEach(Consumer<ComplexNumber> { println(it) })
    }
}
