package kata

fun main() {
    println(alphaSeq("ZpglnRxqenU"))
}
fun alphaSeq(str: String): String {

    return str.toLowerCase().toMutableList().sorted().joinToString(separator = ",") {
        val scnd = it.toString().repeat("abcdefghijklmnopqrstuvwxyz".indexOf(it))
        "${it.toUpperCase()}$scnd"
    }
}

fun betterAlphaSeq(str: String) = str.toLowerCase().toCharArray().sorted().joinToString(",") { it.toString().repeat(it.toInt() - 96).capitalize() }
