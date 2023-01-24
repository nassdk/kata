package kata

fun main() {
    println(
        outed(
            mapOf(
                "tim" to 5,
                "jim" to 5,
                "sim" to 6,
                "pim" to 6,
            ), "john"
        )
    )
}

fun outed(meet: Map<String, Int>, boss: String): String {
    val rating = meet.map { if (it.key == boss) it.value * 2 else it.value }.sumOf { it } / meet.size
    return if (rating <= 5) "Get Out Now!" else "Nice Work Champ!"
}

fun betterOuted(meet: Map<String, Int>, boss: String): String {
    val avg = meet.asIterable().sumBy { if(it.key == boss) it.value*2 else it.value } / meet.size
    return if (avg <= 5) "Get Out Now!" else "Nice Work Champ!"
}

fun cleverOuted(meet: Map<String, Int>, boss: String) = if ((meet.values + meet[boss]!!).average() < 5.5) "Get Out Now!" else "Nice Work Champ!"
