fun main() {
    println(mix("looping is fun but dangerous", "less dangerous than coding"))
}

fun mix(s1: String, s2: String): String {

    val sBuilder = StringBuilder()

    val first = s1.filter {
        it.isLowerCase() && (s2.filter { c -> c == it }.count() > 1 || s2.filter { c -> c == it }.count() > 1)
    }
        .groupingBy { it }
        .eachCount()
        .toList()
        .sortedBy { (_, value) -> value }
        .reversed()
        .toMap()

    val second = s2.filter {
        it.isLowerCase() && (s1.filter { c -> c == it }.count() > 1 || s2.filter { c -> c == it }.count() > 1)
    }
        .groupingBy { it }
        .eachCount()

    first.forEach { entry ->
        when {
            entry.value > second[entry.key] ?: 0 -> sBuilder.append("1:${entry.key.toString().repeat(entry.value)}/")
            entry.value < second[entry.key] ?: 0 -> sBuilder.append("2:${entry.key.toString().repeat(second[entry.key] ?: 0)}/")
            entry.value == second[entry.key] ?: 0 -> sBuilder.append("=:${entry.key.toString().repeat(entry.value)}/")
        }
    }

    println(first)
    println(second)

    return sBuilder.toString().removeRange(sBuilder.count() - 1 until sBuilder.count())
}

