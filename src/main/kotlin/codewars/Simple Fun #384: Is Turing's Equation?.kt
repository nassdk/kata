package codewars

fun main() {
    println(isTuringEquation("1234+5=1239"))
}

fun isTuringEquation(s: String): Boolean {
    val digits = s.split("=", "+").map(String::reversed)
    val sum = digits.take(2).sumOf { it.toInt() }
    val result = digits.last().toInt()
    return sum == result
}

fun betterIsTuringEquation(s: String): Boolean =
    s.split('+', '=').map { it.reversed().toInt() }.let { it[0] + it[1] == it[2] }