package codewars

import kotlin.math.ceil

fun main() {
    print(movie(100, 10, 0.95))
}

fun movie(card: Int, ticket: Int, perc: Double): Int {
    var number = perc * ticket
    var count = 0
    while (ceil(number + card) >= ticket * count) {
        number *= perc
        count++
    }
    return count
}
