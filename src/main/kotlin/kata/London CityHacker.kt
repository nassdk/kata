package kata

import kotlin.math.ceil

fun main() {
    println(londonCityHacker(arrayOf("Northern", "Central", "Circle")))
}

fun londonCityHacker(journey: Array<Any>): String {
    val tubes = journey.count { it is String } * 2.4f
    val buses = getConsecutiveNumbers(journey) * 1.5f
    return "£${String.format("%.2f", tubes + buses)}".replace(",",".")
}

fun getConsecutiveNumbers(srcList: Array<Any>): Int {
    val items = mutableListOf<List<Int>>()
    srcList.forEach { item ->
        when {
            items.isEmpty() && item is Int -> items.add(listOf(item))
            items.isEmpty() && item is String -> Unit
            item is String -> items.add(emptyList())
            item is Int -> {
                val lastList = items.last()
                if (lastList.isEmpty()) {
                    items.add(listOf(item))
                } else {
                    items.dropLast(1)
                    val temp = lastList.toMutableList()
                    temp.add(item)
                    items.add(temp)
                }
            }
        }
    }
    return items.map { ceil(it.size / 2f).toInt() }.sumOf { it }
}

fun betterLondonCityHacker(journey: Array<Any>): String =
    journey.joinToString("") { if (it is Int) "B" else "T" }
        .replace("BB", "B")
        .sumOf { if (it == 'B') 1.5 else 2.4 }
        .let { "£%.2f".format(it) }
