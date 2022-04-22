fun main() {
    println(
        top3("a a a  b  c c  d d d d  e e e e e")
    )
}

fun top3(s: String): List<String> {

    val resultList = arrayListOf<String>()
    val map = s.replace("[^A-Za-z0-9']".toRegex(), " ")
        .replace("\\s+".toRegex(), " ")
        .toLowerCase()
        .split(" ")
        .groupingBy { it }
        .eachCount() as HashMap<String, Int>

    resultList.add(map.maxByOrNull { it.value }?.key ?: "")
    map.remove(resultList.first())
    resultList.add(map.maxByOrNull { it.value }?.key ?: "")
    map.remove(resultList[1])
    resultList.add(map.maxByOrNull { it.value }?.key ?: "")

    return resultList.filter { it.isNotEmpty() && (it.indexOfFirst { it.isLetter() || it.isDigit()  } != -1) }
}

fun betterTop3(s: String): List<String> =
    s.toLowerCase()
        .split("[^a-z']+".toRegex())
        .filter { it.contains("[a-z]".toRegex()) }
        .groupingBy { it }
        .eachCount()
        .entries
        .sortedByDescending { it.value }
        .take(3)
        .map { it.key }