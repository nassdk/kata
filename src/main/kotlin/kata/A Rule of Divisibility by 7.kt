package kata

fun main() {
    print(seven(477557101))
}

fun seven(n: Long): LongArray {

    var strNum = n.toString()

    if (strNum.count() < 3) return longArrayOf(n, 0)
    var count = 0

    while (strNum.count() > 2 || (strNum.toLong() % 7 != 0L && strNum.count() == 3)) {
        strNum = (strNum.substring(0, strNum.lastIndex).toLong() - (strNum.last().toString().toLong() * 2L)).toString()
        count++
    }
    return longArrayOf(strNum.toLong(), count.toLong())
}

fun betterSeven(n: Long, i: Long = 0): LongArray =
    if (n > 99) betterSeven(n / 10 - n % 10 * 2, i + 1)
    else longArrayOf(n, i)