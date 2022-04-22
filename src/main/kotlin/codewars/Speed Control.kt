package codewars

import kotlin.math.floor

fun main() {
    val x = doubleArrayOf(0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61)
    print(gps(s = 20, x))
}

fun gps(s: Int, x: DoubleArray): Int {
    return x.mapIndexed { index, d ->
        if (index != x.lastIndex) x[index + 1] - x[index] else 0.0
    }.map { floor(3600 * it / s).toInt() }.maxOrNull() ?: 0
}

fun betterGps(s: Int, x: DoubleArray) = x.asSequence().zipWithNext { a, b -> (b - a) * 3600 / s }.maxOrNull()?.toInt() ?: 0
fun betterGps2(s: Int, x: DoubleArray) = x.toList()
    .windowed(2) { it[1] - it[0] }
    .map { 3600 * it / s }
    .maxOrNull()
    ?.toInt() ?: 0
