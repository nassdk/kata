package kata

fun main() {
    println(twoOldestAges(listOf(1,5,87,45,8,8)))
}

fun twoOldestAges(ages: List<Int>): List<Int> {
    return ages.sorted().takeLast(2)
}