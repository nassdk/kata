package kata


fun main() {
    print(capitalize("abcdef"))
}

fun capitalize(text: String): List<String> {

    val x = text.mapIndexed { index, c ->
        if (index % 2 == 0) c.toUpperCase() else c.toString()
    }.joinToString("")

    val y = text.mapIndexed { index, c ->
        if (index % 2 != 0) c.toUpperCase() else c.toString()
    }.joinToString("")

    return listOf(x, y)
}

fun betterCapitalize(text: String): List<String> {

    return listOf(
        text.mapIndexed { index, c -> if (index % 2 == 0) c.toUpperCase() else c.toString() }.joinToString(""),
        text.mapIndexed { index, c -> if (index % 2 != 0) c.toUpperCase() else c.toString() }.joinToString("")
    )
}
