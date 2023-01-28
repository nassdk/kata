package kata

import kotlin.math.ceil
import kotlin.math.pow

fun main() {
    print(movie(card = 500, ticket = 15, perc = 0.9))
}

fun movie(card: Int, ticket: Int, perc: Double): Int {
    var count = 0.0
    var sum = 0.0
    while (ticket * count <= ceil(sum) + card) {
        println("current count $count")
        println("current perc pow ${perc.pow(count)}")
        println("current sum ${ceil(sum) + card}")
        println("-------------")

        count++
        sum += ticket * perc.pow(count)
    }
    return count.toInt()
}
