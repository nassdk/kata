package codewars

fun main() {
    println(Kata("A"))
}

fun Kata(word: String): String {
    return when {
        word.length == 1 -> word
        word.length % 2 == 0 -> word.substring(startIndex = word.length / 2 - 1, endIndex = word.length / 2 + 1)
        else -> word[word.length / 2].toString()
    }
}

fun getMiddle(word: String): String = word.substring((word.length - 1) / 2..word.length / 2)
