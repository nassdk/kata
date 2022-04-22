package codewars

fun main() {
    var s1 = arrayOf("cdIw", "tzIy", "xDu", "rThG")
//    "[[cdIw, tzIy xDu rThG], [cdIw tzIy, xDu rThG], [cdIw tzIy xDu, rThG]]"
    println(partlist(s1))
}

fun partlist(arr: Array<String>): Array<Array<String>> {
    val result = arrayListOf<Array<String>>()
    for (i in 0 until arr.lastIndex) {
        var x = ""
        arr.forEachIndexed { index, s ->
            x += if (index - 1 == i) ", $s" else " $s"
        }

        result.add(arrayOf(x.trim()))
    }
    return result.toTypedArray()
}

fun betterPartlist(arr: Array<String>): Array<Array<String>> {
    return (1 until arr.size).map {
        arrayOf(arr.take(it).joinToString(" "), arr.drop(it).joinToString(" "))
    }.toTypedArray()
}