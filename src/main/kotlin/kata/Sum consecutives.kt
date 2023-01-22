package kata

fun main() {
    sumConsecutives(s = listOf(1, 1, 2, 1, 3, 4, 4, 5, 4)) // [2, 2, 1, 3, 8, 4, 2]
}

fun sumConsecutives(s: List<Int>): List<Int> {

    return s.fold(
        mutableListOf<Int>() to mutableListOf<List<Int>>()
    ) { (currentList, allLists), currentItem ->

        if (currentList.isEmpty()) { // Applies only to the very first item
            mutableListOf(currentItem) to allLists
        } else {
            if (currentItem == currentList.first()) { // same char
                currentList.apply { add(currentItem) } to allLists
            } else {
                mutableListOf(currentItem) to allLists.apply { add(currentList) } // Next
            }

        }
    }.let { it.second.apply { add(it.first) } }.map { it.sum() }

}

fun betterSumConsecutives(s: List<Int>): List<Int> {
    val result = arrayListOf<Int>()
    var prev: Int? = null
    s.forEach {
        if (it != prev) result.add(it)
        else result[result.lastIndex] += it
        prev = it
    }
    return result
}