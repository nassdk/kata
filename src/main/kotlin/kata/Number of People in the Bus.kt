package kata

import kotlin.math.abs

fun main() {
    println(people(arrayOf(10 to 0,3 to 5,5 to 8)))
}

fun people(busStops: Array<Pair<Int, Int>>): Int {
    return abs(busStops.sumOf { it.second - it.first })
}