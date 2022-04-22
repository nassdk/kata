package codewars

import kotlin.math.sqrt

fun main() {
    println(predictAge(32, 54, 76, 65, 34, 63, 64, 45))
}

fun predictAge(age1: Int, age2: Int, age3: Int, age4: Int, age5: Int, age6: Int, age7: Int, age8: Int): Int {
    val sum = age1 * age1 + age2 * age2 + age3 * age3 + age4 * age4 + age5 * age5 + age6 * age6 + age7 * age7 + age8 * age8
    return (sqrt(sum.toDouble()) / 2).toInt()
}

fun betterPredictAge(vararg age:Int) = (Math.sqrt((age.map{it*it}.sum().toDouble()))/2).toInt()
