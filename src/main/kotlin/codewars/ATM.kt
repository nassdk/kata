package codewars

fun main() {
    println(count(238))
}

fun count(number: Int): Int {
    if (number % 10 != 0) return -1
    var left = number
    var count = 0

    intArrayOf(500, 200, 100, 50, 20, 10).forEach {
        if (left >= it) {
            val divided = left / it
            left -= divided * it
            count += divided
        }
    }

    return count
}