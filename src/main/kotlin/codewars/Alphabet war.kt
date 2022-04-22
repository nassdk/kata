package codewars

fun main() {
    println(alphabetWar("zdqmwpbs"))
}

fun alphabetWar(fight: String): String {
    val leftSide = mapOf(
        "w" to 4,
        "p" to 3,
        "b" to 2,
        "s" to 1
    )

    val rightSide = mapOf(
        "m" to 4,
        "q" to 3,
        "d" to 2,
        "z" to 1
    )

    val left = fight.filter { leftSide.keys.contains(it.toString()) }
        .groupingBy { it }
        .eachCount()
        .map { it.value * leftSide[it.key.toString()]!! }
        .sum()

    val right = fight.filter { rightSide.keys.contains(it.toString()) }
        .groupingBy { it }
        .eachCount()
        .map { it.value * rightSide[it.key.toString()]!! }
        .sum()

    return when {
        left > right -> "Left side wins!"
        right > left -> "Right side wins!"
        else -> "Let's fight again!"
    }
}

fun betterAlphabetWar(fight: String): String {
    val forces = mapOf('w' to 4, 'p' to 3, 'b' to 2, 's' to 1, 'm' to -4, 'q' to -3, 'd' to -2, 'z' to -1)
    val result = fight.sumBy { forces.getOrDefault(it, 0) }
    return when {
        result > 0 -> "Left side wins!"
        result < 0 -> "Right side wins!"
        else -> "Let's fight again!"
    }
}