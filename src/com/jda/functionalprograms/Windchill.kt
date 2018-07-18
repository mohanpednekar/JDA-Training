/*******************************************************************
 * Purpose:
 *
 * @author Mohan Pednekar
 * @version 1.0
 * @since Jul 11, 2018
 */
package com.jda.functionalprograms

object Windchill {

    @JvmStatic
    fun main(args: Array<String>) {
        val t = java.lang.Double.parseDouble(args[0])
        val v = java.lang.Double.parseDouble(args[1])

        if (Math.abs(t) > 50) {
            println("Wind chill formula doesn't work for the given temperature")
        }
        if (v > 120 || v < 3) {
            println("Wind chill formula doesn't work for the given wind velocity")
        }
        val w = windChill(t, v)
        println("The effective temperature is $w")
    }

    /**
     * @param t
     * temperature in Fahreinheit
     * @param v
     * wind speed in miles/hour
     * @return the effective temperature due to wind chill effect
     */
    private fun windChill(t: Double, v: Double): Double {
        return 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16)
    }
}
