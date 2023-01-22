package kata

fun main() {
//    println(PasswordHider.hidePasswordFromConnection("jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?user=root&password=12345"))
    println(PasswordHider.hidePasswordFromConnection("a?password=12345&user=root"))
}

object PasswordHider {
    fun hidePasswordFromConnection(urlString: String): String {
        val start = urlString.indexOf("password=") + 9
        val passCount = urlString.substringAfter("password=").takeWhile { it.toString() != "&" }.count()
        val end = start + passCount
        return urlString.replaceRange(startIndex = start, endIndex = end, replacement = "*".repeat(passCount))
    }

    fun betterHidePasswordFromConnection(url: String): String {
        return Regex("(?<=password=)[^&]*").replace(url) { "*".repeat(it.value.length) }
    }
}

