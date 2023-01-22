package kata

fun main() {
    println(geometricSequenceElements(2, 3, 5))
    println(geometricSequenceElements(2, 2, 10))
    println(geometricSequenceElements(1, -2, 10))
}

fun geometricSequenceElements(a: Int, r: Int, n: Int): String {
    return arrayListOf(a, a * r).apply {
        while (n > size) {
            add(last() * r)
        }
    }.joinToString()
}

fun geometricSequenceElementsBetter(a: Int, r: Int, n: Int): String =
    generateSequence(a) { it * r }
        .take(n)
        .joinToString(", ")
