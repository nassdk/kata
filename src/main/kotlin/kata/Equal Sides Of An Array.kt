fun main() {
    print(findEvenIndex(intArrayOf(2824, 1774, -1490, -9084, -9696, 23094)))
}

fun findEvenIndex(arr: IntArray): Int {
    val list = arr.toList()
    list.forEachIndexed { index, int ->
        if (list.subList(0, index).sumBy { it } == list.subList(index + 1, arr.size).sumBy { it }) return index
    }
    return -1
}

fun findEvenIndexArray(arr: IntArray): Int {
    for (i in arr.indices) {
        if (arr.sliceArray(0..i).sum() == arr.sliceArray(i until arr.size).sum()) {
            return i
        }
    }
    return -1
}