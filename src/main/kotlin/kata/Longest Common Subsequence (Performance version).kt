fun main() {
    println(lcs("abcdef", "abc"))
}

fun lcs(a: String, b: String) = a.toList().intersect(b.toList()).joinToString(separator = "")