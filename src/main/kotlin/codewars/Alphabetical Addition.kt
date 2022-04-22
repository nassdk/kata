package codewars


fun main() {
    println(addLetters(listOf('y', 'c', 'b')))
}

fun addLetters(arr: List<Char>): Char {
    val alph = "abcdefghijklmnopqrstuvwxyz" //28 //35
    val index = arr.sumBy { alph.indexOf(it) + 1 } - 1
    return alph.getOrNull(if (index >= alph.lastIndex) index - alph.length else index) ?: 'z'
}

fun betterAddLetters(arr: List<Char>) = arr.sumBy { it.toInt() - 96 }.plus(25).rem(26).plus(97).toChar()
fun betterAddLetters2(arr: List<Char>) = 'z' - arr.sumBy { 'z' - it } % 26
