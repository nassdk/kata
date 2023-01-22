package kata

fun main() {
    println(printerError("kkkwwwaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"))
}

fun printerError(s: String): String {
    return "${s.count { "abcdefghijklm".contains(it).not() }}/${s.count()}"
}