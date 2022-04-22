fun main() {
    print(wave(str = " gap "))
}

fun wave(str: String): List<String> {

    val resultList = arrayListOf<String>()

    str.forEachIndexed { index, c ->
        if (c.isLetter())
            resultList.add(str.substring(0, index) + str.substring(index, index + 1).toUpperCase() + str.substring(index + 1))
    }

    return resultList
}

fun betterWave(str: String) = str.indices.map { str.take(it) + str.drop(it).capitalize() }.filter { it != str }