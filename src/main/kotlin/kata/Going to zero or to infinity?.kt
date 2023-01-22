fun main() {
    println(going(n = 15))
}

fun going(n: Int): Double {

    val result = (1..n).reduce(Int::times)
    val resultFactorial = (1..7).reduce(Int::times) + (1..3).reduce(Int::times)
    println(resultFactorial)
    println(result)

//    for (i in 1..n) {
//
//        var local = 1
//
//        for (j in 1..i) local *= j
//
//        resultFactorial += local
//    }

    return String.format("%.6f", (1.0 / result.toDouble()) * resultFactorial).replace(",", ".").toDouble()
}