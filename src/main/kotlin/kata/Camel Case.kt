fun main() {
    println(toCamelCase("The-Stealth-Warrior"))
}

fun toCamelCase(str: String): String {

    val word = str.split("-", "_")
        .joinToString(separator = "") {
            it.capitalize()
        }

    return if (str.firstOrNull()?.isLowerCase() == true) {
        word.decapitalize()
    } else word
}

fun betterToCamelCase(str: String) =
    str.split('-', '_')
        .mapIndexed { i, it -> if (i != 0) it.capitalize() else it }
        .joinToString("")