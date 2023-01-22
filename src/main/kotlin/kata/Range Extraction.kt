import java.lang.StringBuilder

fun main() {
    print(rangeExtraction(intArrayOf(-3, -2, -1, 2, 10, 19, 20, 25)))
}

fun rangeExtraction(arr: IntArray): String {

    val builder = StringBuilder()
    val currentList = arrayListOf<Int>()

    arr.forEachIndexed { index, i ->

        if (index + 1 <= arr.size - 1) {

            if (i + 1 == arr[index + 1] || i - 1 == arr[index + 1]) {
                currentList.add(i)
            } else when {
                index == 0 || (arr[index - 1] != i - 1 && arr[index - 1] != i + 1) -> builder.append("$i,")
                else -> {

                    currentList.add(i)

                    if (currentList.size > 2)
                        builder.append("${currentList.first()}-${currentList.last()},")
                    else currentList.forEach { builder.append("$it,") }

                    currentList.clear()
                }
            }
        } else {
            if (arr[index - 1] == i - 1 || arr[index - 1] == i + 1) {

                currentList.add(i)

                if (currentList.size > 2)
                    builder.append("${currentList.first()}-${currentList.last()}")
                else {
                    builder.append("${currentList.first()},")
                    builder.append("${currentList.last()}")
                }

                currentList.clear()
            } else {
                builder.append("$i")
            }
        }
    }

    return builder.toString()
}

fun bestRangeExtraction(
    arr: IntArray
): String = arr.fold(emptyList<Pair<Int, Int>>()) { rs, x ->
    rs.lastOrNull().run { if (this != null && x - second == 1) rs.dropLast(1) + (first to x) else rs + (x to x) }
}.joinToString(",") { (x, y) -> if (y - x > 1) "$x-$y" else (x..y).joinToString(",") }

fun betterRangeExtraction(arr: IntArray): String {
    var str = ""

    arr.forEachIndexed { index, element ->
        if (index == 0 || element - arr[index - 1] > 1)
            str += ",$element"
        else if ((index < arr.size - 1 && arr[index + 1] - element > 1) || index == arr.size - 1)
            if (index > 1 && element - arr[index - 2] == 2)
                str += "-$element"
            else
                str += ",$element"

    }

    return str.drop(1)
}