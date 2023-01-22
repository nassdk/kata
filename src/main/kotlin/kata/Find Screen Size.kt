package kata

fun main() {
    println(findScreenHeight(598, "4:3"))
}

fun findScreenHeight(width: Int, ratio: String): String {
    val ratioArr = ratio.split(":").map(String::toDouble)
    val height = ((width.toDouble() / ratioArr.first()) * ratioArr.last()).toInt()
    return "${width}x$height"
}