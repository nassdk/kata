package kata

fun main() {
    println(betteratchSignChange(arrayOf(-47, 84, -30, -11, -5, 74, 77)))
}

fun catchSignChange(arr: Array<Int>): Int {
    var count = 0

    arr.forEachIndexed { index, i ->
        if (index + 1 > arr.lastIndex) return@forEachIndexed
        if ((i > -1 && arr[index + 1] < 0) || (i < 0 && arr[index + 1] > -1)) {
            count++
        }
    }

    return count
}

fun betteratchSignChange(arr: Array<Int>): Int {
    val x = arr.map { it < 0 }
    val y = x.zipWithNext { a, b -> a != b }

    return y.count()
}

//fun catchSignChange(arr: Array<Int>): Int =
//    arr.asSequence().windowed(2).count { (x, y) -> (x >= 0) != (y >= 0) }