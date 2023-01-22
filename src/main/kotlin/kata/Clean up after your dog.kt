package kata

fun main() {
    println(crap(arrayOf(charArrayOf('_','_','_','_'), charArrayOf('_','_','_','@'), charArrayOf('_','_','@', '_')), 1, 1))
}

fun crap(x: Array<CharArray>, bags: Int, cap: Int): String {
    return when {
        x.any { it.contains('D') } -> "Dog!!"
        x.sumBy { it.count { it == '@' } } > bags * cap -> "Cr@p"
        else -> "Clean"
    }
}