package codewars

fun main() {
    println(fizzBuzzCuckooClock("21:00"))
}

fun fizzBuzzCuckooClock(time: String): String {

    val (hours, minutes) = time.split(":").map(String::toInt)

    return when {
        minutes == 0 -> {
            when (hours) {
                0 -> "Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo Cuckoo"
                else -> "Cuckoo".repeat(if (hours > 12) hours - 12 else hours)
            }
        }
        minutes == 30 -> "Cuckoo"
        minutes % 3 == 0 && minutes % 5 == 0 -> "Fizz Buzz"
        minutes % 3 == 0 -> "Fizz"
        minutes % 5 == 0 -> "Buzz"
        else -> "tick"
    }
}