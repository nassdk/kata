package codewars

fun main() {
    println(CodewarsLeaderboardClimber.leaderBoard("g964", 36097, 20000))
}

object CodewarsLeaderboardClimber {
    fun leaderBoard(user: String, userScore: Int, yourScore: Int): String {
        if (yourScore > userScore) return "Winning!"
        if (yourScore == userScore) return "Only need one!"
        val diff = userScore - yourScore
        val beta = diff / 3
        val eightKy = diff - beta * 3
        return buildString {
            append("To beat $user's score, I must complete $beta Beta kata and $eightKy 8kyu kata.")
            if (beta + eightKy > 1000) append(" Dammit!")
        }
    }
}