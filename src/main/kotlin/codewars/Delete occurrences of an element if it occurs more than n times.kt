fun main() {
    println(deleteNth(elements = intArrayOf(1, 1, 2, 3, 5, 1, 2, 3, 4), maxOcurrences = 1))
}

fun deleteNth(elements: IntArray, maxOcurrences: Int): IntArray {

    println(elements.groupBy { it }.map { map ->
        map.value.dropLastWhile { map.value.count() <= maxOcurrences }
    })

    println(
        elements.groupBy { it }
    )


    return intArrayOf(1)
}