package kata

fun main() {
    println(duplicates(intArrayOf(1, 2, 2, 20, 6, 20, 2, 6, 2)))
}

fun duplicates(array: IntArray): Int {

    return array.toMutableList()
        .groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .map { it.key to it.value / 2 }
        .sumOf { it.second }
}

fun betterDuplicates(array: IntArray) = array.groupBy { it }.map { it.value.size / 2 }.sum()
