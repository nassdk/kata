package codewars

fun main() {
    println(well(arrayOf("good", "bad", "bad")))
}

fun well(x: Array<String>): String = when (x.count { it == "good" }) {
    0 -> "Fail!"
    in 1..2 -> "Publish!"
    else -> "I smell a series!"
}