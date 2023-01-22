package kata

fun main() {
    println(Kata.grid(n = 52))
}

// 133 / 26
object Kata {
    fun grid(n: Int): String? {
        if (n == 0) return ""
        if (n < 0) return null

        val alphabet = "abcdefghijklmnopqrstuvwxyz"

        val result = (0 until n).fold(
            initial = "",
            operation = { acc, row ->
                val mltpAlph = List((row + n) / alphabet.length + 1) { alphabet }
                    .joinToString("")

                acc + "\n" + mltpAlph.substring(row, row + n)
                    .toCharArray()
                    .joinToString(separator = " ")
            }
        ).trim()

        return result
    }
}

fun grid(n: Int) = if (n < 0) null else (0 until n).joinToString("\n") {
    generateSequence('a') { it.inc().takeIf { it <= 'z' } ?: 'a' }.drop(it).take(n).joinToString(" ")
}