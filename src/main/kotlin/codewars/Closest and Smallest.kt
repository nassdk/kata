fun main() {
    val s = "466874 170 333771 177 44791 15 80369 166 361158 116 16"
    print(closest(s))
}

fun closest(strng: String): IntArray {

    val figuresString = strng.split(" ")
    val mapFigues = hashMapOf<String, Int>()

    figuresString.forEach { numberString ->
        mapFigues[numberString] = numberString.sumOf { it.toString().toInt() }
    }

    println(mapFigues.minByOrNull { it.value }?.value ?: 0)
    println(figuresString.indexOf(mapFigues.minByOrNull { it.value }?.key))
    println(mapFigues.minByOrNull { it.value }?.key?.toInt() ?: 0)

    return intArrayOf(
        mapFigues.minByOrNull { it.value }?.value ?: 0,
        figuresString.indexOf(mapFigues.minByOrNull { it.key }?.key),
        mapFigues.minByOrNull { it.value }?.key?.toInt() ?: 0
    )
}