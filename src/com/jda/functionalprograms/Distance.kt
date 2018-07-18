package com.jda.functionalprograms

import com.jda.utility.Utility

object Distance {

    @JvmStatic
    fun main(args: Array<String>) {
        if (!Utility.checkCmdArgs(args, 2)) {
            return
        }
        val x = java.lang.Double.parseDouble(args[0])
        val y = java.lang.Double.parseDouble(args[1])
        Utility.printLine("The distance of (" + x + "," + y + ") from origin is " + distanceFromOrigin(x, y))
    }

    private fun distanceFromOrigin(x: Double, y: Double): Double {
        return Utility.euclideanDistance(x, y, 0.0, 0.0)
    }
}
