package kata

fun main() {
    println(firstReverseTry(intArrayOf(1, 2, 3, 4, 5)))
}

fun firstReverseTry(arr: IntArray): IntArray {

    if (arr.isEmpty()) return intArrayOf()
    if (arr.size == 1) return arr
    if (arr.size == 2) return arr.reversed().toIntArray()
    val first = arr.firstOrNull() ?: return intArrayOf()
    val last = arr.lastOrNull() ?: return intArrayOf()
    val result = arrayListOf<Int>()
    result.add(last)
    arr.forEachIndexed { index, i ->
        if (index != 0 && index != arr.lastIndex) {
            result.add(i)
        }
    }
    result.add(first)
    return result.toIntArray()
}

fun betterFirstReverseTry(arr: IntArray) = if (arr.size < 2) arr else arr.copyOf().apply { this[0] = arr[lastIndex]; this[lastIndex] = arr[0] }