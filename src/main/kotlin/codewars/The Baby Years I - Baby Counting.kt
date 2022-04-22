package codewars

fun main() {
    println(babyCount("Why the hell are there so many BABiesWhy the hell are there so many BABiesWhy the hell are there so many BABiesWhy the hell are there so many BABiesWhy the hell are there so many BABies?!"))
}

fun babyCount(x: String): Int? {

    return x.filter { it.toLowerCase().toString() in "bay" }
        .groupingBy { it }
        .eachCount()
        .map {
            if (it.key.toLowerCase().toString() == "b") it.value / 2 else it.value
        }.minOrNull()
}

//fun babyCount(x: String): Int? {
//
//    val onlyLetters = x.filter { it.toString() in "bay" }
//    if (!onlyLetters.contains("b") || !onlyLetters.contains("a") || !onlyLetters.contains("y")) return null
//
//    return 0
//}