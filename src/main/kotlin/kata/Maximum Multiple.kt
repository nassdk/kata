package kata

fun main() {
    println(maxMultiple(2, 7))
}

fun maxMultiple(d: Int, b: Int): Int {
    return (7 downTo 0).first { it % d == 0 }
}

fun betterMaxMultiple(d: Int, b: Int) = b / d * d
