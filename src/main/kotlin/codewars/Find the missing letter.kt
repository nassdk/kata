fun main() {
    print(findMissingLetterBetter(charArrayOf('a', 'b', 'c', 'd', 'f')))
}


fun findMissingLetter(array: CharArray): Char {

    val alphabet = if (array.first().isUpperCase())
        "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray()
    else "abcdefghijklmnopqrstuvwxyz".toCharArray()

    alphabet.indexOfFirst {
        array.first() == it
    }.run {
        return alphabet.sliceArray(this until this + array.count()).first { !array.contains(it) }
    }
}

fun findMissingLetterBetter(array: CharArray) = (array.first()..array.last()).first { it !in array }
