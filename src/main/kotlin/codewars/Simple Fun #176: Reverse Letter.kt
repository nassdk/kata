package codewars

fun main() {
    println(reverseLetter("krishan"))
}

fun reverseLetter(str: String): String {
    return str.filter { "abcdefghijklmnopqrstuvwxyz".contains(it.toString()) }.reversed()
}

fun betterReverseLetter(str: String): String {
    return str.filter(Char::isLetter).reversed()
}