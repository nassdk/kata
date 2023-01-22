fun main() {
    print(find(arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)))
}

fun find(integers: Array<Int>) = when {
    integers.filter { it % 2 == 0 }.size > 1 -> integers.first { it % 2 != 0 }
    integers.filter { it % 2 != 0 }.size > 1 -> integers.first { it % 2 == 0 }
    else -> 0
}

fun findBetter(integers: Array<Int>) = integers.singleOrNull { it % 2 == 0 } ?: integers.single { it % 2 != 0 }
