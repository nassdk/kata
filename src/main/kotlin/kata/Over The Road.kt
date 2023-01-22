package kata

fun main() {
    println(overTheRoad(7, 11))
}

fun overTheRoad(address: Int, n: Int): Int {
    return n * 2 - address + 1
}