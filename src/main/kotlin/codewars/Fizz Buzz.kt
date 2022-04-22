package codewars

fun main() {
    val result = fizzBuzz(10)
    println(result)
}

fun fizzBuzz(n: Int): Array<String> {
    return (1..n).toMutableList().map(Int::toString).map {
        when {
            it.toInt() % 3 == 0 && it.toInt() % 5 == 0 -> "FizzBuzz"
            it.toInt() % 3 == 0 -> "Fizz"
            it.toInt() % 5 == 0 -> "Buzz"
            else -> it
        }
    }.toTypedArray()
}

fun betterFizzBuzz(n: Int) = (1..n).map {
    when{it % 15 == 0 -> "FizzBuzz"
        it % 5 == 0 -> "Buzz"
        it % 3 == 0 -> "Fizz"
        else -> "$it"
    }
}.toTypedArray()