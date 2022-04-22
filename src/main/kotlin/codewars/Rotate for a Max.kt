package codewars

fun main() {
    println(maxRot(56789))
}

fun maxRot(n: Long): Long {
    val lastIndex = n.toString().lastIndex
    val end = n.toString().substring(0, 1)
    val start = n.toString().substring(1, lastIndex + 1)
    val numbers = arrayListOf("$start$end")

    for (i in 1 .. lastIndex) {
        val m = numbers.last()
        val s = m.substring(0, i)
        val e = m.substring(i, lastIndex + 1)
        numbers.add("$s$e")
    }

    return numbers.map(String::toLong).maxOrNull() ?: 0L
}