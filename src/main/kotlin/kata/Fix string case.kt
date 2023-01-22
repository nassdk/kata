package kata

fun main() {
    println(FixStringCase.solve("CODe"))
}

object FixStringCase {

    fun solve(s: String): String {
        val shouldBeUpper = s.count { it.isUpperCase() } > s.count { it.isLowerCase() }
        return if (shouldBeUpper) s.toUpperCase() else s.toLowerCase()
    }

}