package com.jda.data_structure_programs

import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths

internal interface List<T> {

    val isEmpty: Boolean

    fun add(item: T)

    fun remove(item: T)

    fun search(item: T): Boolean

    fun size(): Int

    fun append(item: T)

    fun index(item: T): Int

    fun insert(pos: Int, item: T)

    fun pop(): T?

    fun pop(pos: Int): T?
}

class UnorderedList<T> : List<T> {

    override val isEmpty: Boolean
        get() = false

    override fun add(item: T) {
    }

    override fun remove(item: T) {
    }

    override fun search(item: T): Boolean {
        return false
    }

    override fun size(): Int {
        return 0
    }

    override fun append(item: T) {
    }

    override fun index(item: T): Int {
        return 0
    }

    override fun insert(pos: Int, item: T) {
    }

    override fun pop(): T? {
        return null
    }

    override fun pop(pos: Int): T? {
        return null
    }

    companion object {

        internal var DATA_PATH = "C:/Users/1023345/IdeaProjects/JDA-Training/data"
        internal var INPUT = "$DATA_PATH/input/unorderedLists.txt"
        internal var OUTPUT = "$DATA_PATH/output/unorderedLists.txt"

        @JvmStatic
        fun main(args: Array<String>) {
            val words: Array<String>
            try {
                words = String(Files.readAllBytes(Paths.get(INPUT))).split("\\s".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
            } catch (e: IOException) {
                println("Reading file failed")
                return
            }
        }
    }
}
