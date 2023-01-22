package kata

import kotlin.math.abs

fun main() {
    val s1 = arrayOf("ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh")
    val s2 = arrayOf("bbbaaayddqbbrrrv")
    println(betterMxdiflg(s1, s2))
}

fun mxdiflg(a1: Array<String>, a2: Array<String>): Int {

    val results = arrayListOf<Int>()
    a1.forEach { a ->
        a2.forEach { b ->
            results.add(abs(a.count() - b.count()))
        }
    }

    return results.maxOrNull() ?: 0
}

fun betterMxdiflg(a1: Array<String>, a2: Array<String>): Int {
    return a1.flatMap { s1 -> a2.map { abs(s1.length - it.length) } }.maxOrNull() ?: -1
}