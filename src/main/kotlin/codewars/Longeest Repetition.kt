
fun main() {
    print(longestRepetitionBetter(s = "aaaaaabbdsssssssssadvdddd"))
}

fun longestRepetition(s: String): Pair<Char?,Int> {

    if (s.length == 0) return Pair(null, 0)

    var streak = 0
    var streakValue = s.first()

    var currentStreak = 0
    var currentStreakValue = s.first()

    s.forEach { char ->

        if (currentStreakValue == char) {
            currentStreak += 1
        }
        else {
            if (currentStreak > streak) {
                streak = currentStreak
                streakValue = currentStreakValue
            }

            currentStreakValue = char
            currentStreak = 1
        }
    }

    if (currentStreak > streak) {
        streak = currentStreak
        streakValue = currentStreakValue
    }

    return Pair(streakValue, streak)
}

fun longestRepetitionBetter(s: String): Pair<Char?, Int> =
    "(.)\\1*".toRegex().findAll(s).map { it.value }.maxByOrNull { it.length }?.let { it[0] to it.length } ?: Pair(null, 0)