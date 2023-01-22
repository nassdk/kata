package kata

fun main() {
    println(TimeFormatter.formatDuration(132030240))
}

object TimeFormatter {

    fun formatDuration(seconds: Int): String {
        return when {
            seconds == 0 -> "now"
            seconds == MINUTE_SECONDS -> "1 minute"
            seconds == HOUR_SECONDS -> "1 hour"
            seconds == DAY_SECONDS -> "1 day"
            seconds == YEAR_SECONDS -> "1 year"
            seconds < MINUTE_SECONDS -> "$seconds second"
            seconds < HOUR_SECONDS -> {
                val mins = seconds / MINUTE_SECONDS
                val secs = seconds % MINUTE_SECONDS

                buildResult(minutes = mins, seconds = secs)
            }
            seconds < DAY_SECONDS -> {
                val hours = seconds / HOUR_SECONDS
                val hoursLeft = seconds % HOUR_SECONDS
                val mins = hoursLeft / MINUTE_SECONDS
                val secs = hoursLeft % MINUTE_SECONDS

                buildResult(hours = hours, minutes = mins, seconds = secs)
            }
            seconds < YEAR_SECONDS -> {
                val days = seconds / DAY_SECONDS //182
                val daysDiff = seconds % DAY_SECONDS //628
                val hours = daysDiff / HOUR_SECONDS //0
                val hoursLeft = daysDiff % HOUR_SECONDS
                val mins = hoursLeft / MINUTE_SECONDS
                val secs = hoursLeft % MINUTE_SECONDS

                buildResult(days = days, hours = hours, minutes = mins, seconds = secs)
            }
            else -> {
                val years = seconds / YEAR_SECONDS
                val yearsDiff = seconds % YEAR_SECONDS // 4 //126 144 000
                val days = yearsDiff / DAY_SECONDS
                val daysDiff = seconds % DAY_SECONDS
                val hours = daysDiff / HOUR_SECONDS
                val hoursLeft = daysDiff % HOUR_SECONDS
                val mins = hoursLeft / MINUTE_SECONDS
                val secs = hoursLeft % MINUTE_SECONDS

                buildResult(years = years, days = days, hours = hours, minutes = mins, seconds = secs)
            }
        }
    }

    private fun buildResult(
        seconds: Int? = null,
        minutes: Int? = null,
        hours: Int? = null,
        days: Int? = null,
        years: Int? = null
    ): String {
        return buildString {
            years?.let {
                if (it == 0) return@let
                append(it)
                append(" ")
                append(getProperPredicate(count = it, text = "year"))
            }
            days?.let {
                if (it == 0) return@let
                when {
                    years == null || years == 0 -> Unit
                    hours == 0 && minutes == 0 && seconds == 0 -> append(" and ")
                    else -> append(", ")
                }
                append(it)
                append(" ")
                append(getProperPredicate(count = it, text = "day"))
            }
            hours?.let {
                if (it == 0) return@let
                when {
                    (years == null || years == 0) && (days == null || days == 0) -> Unit
                    minutes == 0 && seconds == 0 -> append(" and ")
                    else -> append(", ")
                }
                append(it)
                append(" ")
                append(getProperPredicate(count = it, text = "hour"))
            }
            minutes?.let {
                if (it == 0) return@let
                when {
                    (years == null || years == 0)
                            && (days == null || days == 0)
                            && (hours == null || hours == 0) -> Unit
                    seconds == 0 -> append(" and ")
                    else -> append(", ")
                }
                append(it)
                append(" ")
                append(getProperPredicate(count = it, text = "minute"))
            }
            seconds?.let {
                if (it == 0) return@let
                when {
                    (years == null || years == 0)
                            && (days == null || days == 0)
                            && (hours == null || hours == 0)
                            && (minutes == null || minutes == 0) -> Unit
                    else -> append(" and ")
                }
                append(seconds)
                append(" ")
                append(getProperPredicate(count = it, text = "second"))
            }
        }
    }

    private fun getProperPredicate(count: Int, text: String): String {
        return if (count > 1) "${text}s" else text
    }

    private const val MINUTE_SECONDS = 60
    private const val HOUR_SECONDS = 3600
    private const val DAY_SECONDS = 86400
    private const val YEAR_SECONDS = 31536000 //126 144 000 + 5 875 200 + 10 800 + 240
}

fun betterFormatDuration(sec: Int): String {
    if (sec == 0) return "now"
    val seconds = sec % 60
    val minutes = sec % 3600 / 60
    val hours = sec % 86400 / 3600
    val days = sec % 31536000 / 86400
    val years = sec / 31536000

    val list = listOf(years, days, hours, minutes, seconds)
        .zip(listOf("years", "days", "hours", "minutes", "seconds"))
        .filter { it.first > 0 }
        .map { "${it.first} ${if (it.first == 1) it.second.dropLast(1) else it.second}" }

    return list
        .chunked(if (list.size == 1) list.size else list.lastIndex)
        .joinToString(" and ") { it.joinToString() }
}