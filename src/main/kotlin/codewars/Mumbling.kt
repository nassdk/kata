package codewars

fun main() {
    print(accum("ZpglnRxqenU"))
}

fun accum(s: String): String {
    return buildString {
        s.toLowerCase().forEachIndexed { index, c ->
            if (index > 0) append("-")
            repeat(index + 1) {
                val value = if (it == 0) c.toString().toUpperCase() else c.toString()
                append(value)
            }
        }
    }
}

fun betterAccum(s: String): String = s.mapIndexed { index, char ->
    char.toUpperCase() + char.toString().toLowerCase().repeat(index)
}.joinToString("-")
