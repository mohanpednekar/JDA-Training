package com.jda.functionalprograms

import com.jda.utility.Utility

object HelloUser {

    private val USER_NAME_PLACEHOLDER = "<<UserName>>"

    @JvmStatic
    fun main(args: Array<String>) {
        val template = "Hello <<UserName>>, How are you?"
        println("The template is as follows")
        println(template)
        println("What's your name?")
        val reader = Utility().Reader()
        val name = reader.readString()
        val greeting = template.replace(USER_NAME_PLACEHOLDER, name)
        println(greeting)
    }
}
