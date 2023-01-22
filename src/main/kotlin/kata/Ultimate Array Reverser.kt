package kata

fun main() {
    println(reverse(listOf("I", "like", "big", "butts", "and", "I", "cannot", "lie!"))) //["g", "ibek", "ilI"] //gibekilI
}

fun reverse(a: List<String>): List<String> {

    var str = a.joinToString(separator = "").reversed()
    val arr = arrayListOf<String>()
    a.forEach {
        val temp = str.substring(0, it.length)
        arr.add(temp)
        str = str.replaceFirst(temp, "")
    }

    return arr
}