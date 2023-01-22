package kata

fun main() {
    println(repeats(intArrayOf(4, 5, 7, 5, 4, 8)).toLong())
}

fun repeats(arr: IntArray): Int {
    return arr.toMutableList()
        .groupingBy { it }
        .eachCount()
        .filter { it.value == 1 }
        .keys
        .sum()
}