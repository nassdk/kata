package kata

fun main() {
    println(isLeapYear(2000))
}


fun isLeapYear(year: Int): Boolean {
    return when {
        year % 400 == 0 -> true
        year % 100 == 0 -> false
        year % 4 == 0 -> true
        else -> false
    }
}