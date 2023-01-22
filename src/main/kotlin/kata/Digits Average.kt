package kata

import kotlin.math.ceil

fun main() {
    println(digitsAverage(346))
}

fun digitsAverage(input: Int): Int {
    val strInput = input.toString()
    if (strInput.length == 1) return input
    val list = mutableListOf<String>()
    strInput.forEachIndexed { index, item ->
        if (index != strInput.lastIndex) {
            val first = item.digitToInt()
            val second = strInput[index + 1].digitToInt()
            list.add(ceil((first + second) / 2f).toInt().toString())
        }
    }

    return digitsAverage(list.joinToString("").toInt())
}

fun betterDigitsAverage(input: Int): Int {
    var digits = input.toString().map(Character::getNumericValue)
    while (digits.size > 1) {
        digits = digits.zipWithNext { a, b -> (a + b + 1) / 2 }
    }
    return digits.first()
}