package codewars

fun main() {
    println(moveTen("testcase"))
}

fun moveTen(s: String): String {
    val alph = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
    return s.map {
        val i = alph.indexOf(it)
        alph[i + 10]
    }.joinToString(separator = "")
}