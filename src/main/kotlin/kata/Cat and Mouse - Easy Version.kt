package kata

fun main() {
    println(catMouse("C..m"))
}

fun catMouse(s: String): String {
    return if (s.count { it.toString() == "." } > 3) "Escaped" else "Caught"
}