package codewars

fun main() {
    println(makeComplement("TAACG"))
}

fun makeComplement(dna : String) : String {
    return dna.map {
        when (it.toString()) {
            "A" -> "T"
            "T" -> "A"
            "C" -> "G"
            "G" -> "C"
            else -> it
        }
    }.joinToString("")
}