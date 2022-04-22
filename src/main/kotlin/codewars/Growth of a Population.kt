package codewars

import kotlin.math.roundToInt

fun main() {
//    println(nbYear(1500000, 2.5, 10000, 2000000))
    println(nbYearBetter(1500000, 2.5, 10000, 2000000, 0))
}

fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int {
    var year = 0
    var x = pp0

    val convertedPercent = percent / 100

    while (p > x) {
        x += (x * convertedPercent).roundToInt() + aug
        year++

        if (p <= x) {
            break
        }
    }

    return year
}

fun nbYearBetter(pp0: Int, percent: Double, aug: Int, p: Int, i: Int): Int {
    val x = pp0 + (pp0 * (percent / 100)).roundToInt() + aug
    return if (x >= p) i + 1
    else nbYearBetter(x, percent, aug, p, i + 1)
}

fun nbYearMuchBetter(pp0: Int, percent: Double, aug: Int, p: Int, i: Int): Int {
    return generateSequence(pp0.toDouble()) { it * (1 + percent / 100) + aug }.takeWhile { it < p }.count()
}
