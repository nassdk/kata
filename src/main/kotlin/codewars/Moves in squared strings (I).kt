package codewars

fun main() {
    val v = "hSgdHQ\nHnDMao\nClNNxX\niRvxxH\nbqTVvA\nwvSyRu"
    val h = "lVHt\nJVhv\nCSbg\nyeCt"
    // lVHt\nJVhv\nCSbg\nyeCt


//    println(Opstrings.oper(Opstrings::vertMirror, v))
    println(Opstrings.oper(Opstrings::horMirror, h))
}

object Opstrings {

    fun vertMirror(strng: String): String {
        return strng.split("\n").joinToString(separator = "\n", transform = String::reversed)
    }

    fun horMirror(strng: String): String {
        return strng.split("\n").reversed().joinToString(separator = "\n")
    }

    fun oper(transform: (String) -> String, s: String): String {
        return transform.invoke(s)
    }
}