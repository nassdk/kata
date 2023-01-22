package kata

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.roundToInt


fun main() {
    val a = doubleArrayOf(14.0, 30.0, 5.0, 7.0, 9.0, 11.0, 16.0)
    println(90.5.roundToInt())
    println(ceil(90.5))
    println(floor(90.5))
    println(newAvg(a, 90.0))
}


fun newAvg(a: DoubleArray, navg: Double): Long {
    val last = ceil(navg * (a.size + 1) - a.sum()).toLong()
    return if (last < 0) throw IllegalArgumentException() else last
}


// sum / 8