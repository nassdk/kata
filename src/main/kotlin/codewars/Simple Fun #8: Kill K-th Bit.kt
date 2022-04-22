package codewars

fun main() {
    println(killKthBit(1084197039, 15))
}

fun killKthBit(n: Int, k: Int): Int {
    if (n == 0) return 0
    val x = n.toString(radix = 2).reversed()
    println(x)
    val y = x.replaceRange(k - 1, k, "0").reversed()
    println(y)
    return y.toInt(radix = 2)
}

fun betterKillKthBit(n: Int, k: Int): Int {
    return n and (1 shl k - 1).inv()
}
//fun killKthBit(n: Int, k: Int): Int {
//    return if (n == 0) return 0 else n.toUInt()
//        .toString(radix = 2)
//        .reversed()
//        .replaceRange(k - 1, k, "0")
//        .reversed()
//        .toInt(radix = 2)
//}