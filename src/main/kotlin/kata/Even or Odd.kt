package kata

import kotlin.math.abs

fun main() {
//    println(twiceAsOld(42, 21))
//    val x = sum(listOf(1,2, "1"))
//    val x = calculateYears(10)
    val a = arrayListOf("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")
    println(evenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9), 3))
}

fun twiceAsOld(dadYearsOld: Int, sonYearsOld: Int): Int {
    return abs(dadYearsOld - sonYearsOld * 2)
}

fun countPositivesSumNegatives(input: Array<Int>?): Array<Int> {
    if (input.isNullOrEmpty()) return arrayOf()
    return listOf(
        input.count { it > 0 },
        input.filter { it < 0 }.sum()
    ).toTypedArray()
}

fun sum(mixed: List<Any>): Int {
    return mixed.map {
        if (it is String) {
            it.toInt()
        } else it
    }.sumBy { it as Int }
}

fun dutyFree(normPrice: Int, discount: Int, hol: Int): Int {
    return (hol.toFloat() / (normPrice.toFloat() * discount.toFloat() / 100f)).toInt()
}

fun digitize(n: Long): IntArray {
    return n.toString().reversed().map {
        it.toString().toInt()
    }.toIntArray()
}

fun calculateYears(years: Int): Array<Int> {
    var catsYears = 15
    var dogsYears = 15
    if (years > 1) {
        catsYears += 9
        dogsYears += 9
    }

    if (years > 2) {
        val multiplier = years - 2
        catsYears += multiplier * 4
        dogsYears += multiplier * 5
    }
    return arrayOf(years, catsYears, dogsYears)
}

fun removeChar(str: String): String {
    // You got this!
    return str.drop(1).dropLast(1)
}

fun invert(arr: IntArray): IntArray {
    return arr.map {
        it * -1
    }.toIntArray()
}


fun grow(arr: IntArray): Int {
    return arr.reduce { acc, i -> i * acc }
}

fun expressionsMatter(a: Int, b: Int, c: Int): Int {
    return listOf(
        a * (b + c),
        a * b * c,
        a + b * c,
        (a + b) * 3
    ).maxOrNull() ?: 0
}

fun points(games: List<String>): Int {
    return games.sumBy {
        val goals = it.split(":")
        val x = goals.first()
        val y = goals.last()
        when {
            x > y -> 3
            x == y -> 1
            else -> 0
        }
    }
}

fun seatsInTheater(nCols: Int, nRows: Int, col: Int, row: Int): Int {
    val totalSeats = nCols * nRows
    val distructingArea = (nCols - col - 1) * (nRows - row)
    return totalSeats - distructingArea
}

fun elevator(left: Int, right: Int, call: Int): String {
    return if (Math.abs(call - left) > Math.abs(call - right)) "right" else "left"
}

fun oddCount(n: Int): Int {
    return n / 2
}

fun replace(s: String): String {
    val vowels = "aeiouAEIOU"
    return s.map {
        if (vowels.contains(it.toString())) {
            "!"
        } else it
    }.toString()
}
//01000000X000X011X0X

fun infected(s: String): Double {
    val peoples = s.split("X").joinToString("") {
        if (it.contains("1")) {
            it.replace("0", "1")
        } else it
    }

    if (peoples.isEmpty()) return 0.0
    val infected = peoples.count { it.toString() == "1" }
    return 100.0 * infected / peoples.count()
}


fun quadratic(a: Double, b: Double, c: Double): Double {
    return b * b - 4 * a * c
}

fun containAllRots(strng: String, arr: ArrayList<String>): Boolean {

    if (strng.isEmpty()) return true
    if (strng.count() > arr.count()) return false
    return arr.distinct().count {
        strng.count() == it.count() && strng.toList().containsAll(it.toList())
    } == strng.count()
}

fun prevMultOfThree(n: Int): Int? {
    var number = n.toString()
    while(number.toInt() % 3 != 0 && number.count() > 1) {
        number = number.dropLast(1)
    }

    return if (number.count() == 1 && number.toInt() % 3 != 0) null else number.toInt()
}

// Just because the challenge says "array" does not mean we should use a Kotlin Array...
fun evenNumbers(array: List<Int>, number: Int): List<Int> {
    return array.filter { it % 2 == 0 }.takeLast(number.inv())
}


//    assertEquals(166, dutyFree(12, 50, 1000))
// 12 * 5 / 10
