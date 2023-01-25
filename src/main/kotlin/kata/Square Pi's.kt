package kata

import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    println(squarePi(10))
}

fun squarePi(digits: Int): Int {
    val pi = "31415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679"
    return ceil(
        sqrt(
            pi.take(digits).map {
                it.digitToInt() * it.digitToInt()
            }.sum().toFloat()
        )
    ).toInt()
}