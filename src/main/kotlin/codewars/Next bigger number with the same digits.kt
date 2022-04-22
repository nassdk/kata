import java.util.*

fun main() {
    print(nextBiggerNumber(2017))
}

fun nextBiggerNumber(n: Long): Long {

    val combinations = arrayListOf(n)

    val string = n.toString()
    val list = string.toMutableList()

    string.forEachIndexed { index, c ->
        for (ind in 0 until string.count()) {
            Collections.swap(list, index, ind)
            combinations.add(list.joinToString("").toLong())
        }
    }

    val sortedComb = combinations.distinct().sorted()
    var valueToReturn = n
    val i = sortedComb.indexOf(n)
    valueToReturn = if (sortedComb.count() - 1 >= i + 1) {
        sortedComb[i + 1]
    } else sortedComb.maxOrNull() ?: -1

    return if (valueToReturn == n) -1 else valueToReturn
}

//fun String.swapChars(firstIndex: Int, secondIndex: Int): String {
//    val firstReplace = replaceRange(firstIndex .. firstIndex, this[secondIndex].toString())
//    return firstReplace.replaceRange(secondIndex..secondIndex, this[firstIndex].toString())
//}