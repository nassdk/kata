package codewars

fun main() {
    val a = intArrayOf(17, 17, 15, 14, 8, 7, 7, 5, 4, 4, 1)
    println(makeValley(a))
}

fun makeValley(arr: IntArray): IntArray {

    val leftWing = arr.filterIndexed { index, _ -> index % 2 == 0 }.sorted().reversed()
    val rightWing = arr.filterIndexed { index, _ -> index % 2 != 0 }.sorted()
    val list = arrayListOf<Int>()
    list.addAll(leftWing)
    list.addAll(rightWing)

    return list.toIntArray()
}

fun betterMakeValley(arr: IntArray) = arr.sortedDescending().chunked(2)
    .let { it.map { it[0] } + it.mapNotNull { it.getOrNull(1) }.reversed() }.toIntArray()