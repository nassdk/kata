import kotlin.math.max

fun main() {
    print(maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}

fun maxSequence(arr: List<Int>): Int {

    val sumList = arrayListOf<Int>()

    when {
        !arr.any { it >= 0 } || arr.isEmpty() -> return 0
        else -> {
            arr.forEachIndexed { index, element ->
                sumList.add(element)
                for (ind in index until arr.size) {
                    if (ind != 0 && ind != index)
                        sumList.add(sumList.last() + arr[ind])
                }
            }
        }
    }
    return sumList.maxOrNull() ?: 0
}

fun betterMaxSequence(arr: List<Int>): Int {
    var max = 0
    arr.indices.forEach { outer ->
        (outer..arr.size).forEach { inner ->
            max = max(arr.subList(outer, inner).sum(), max)
        }
    }
    return max
}