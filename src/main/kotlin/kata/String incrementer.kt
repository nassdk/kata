fun main() {
    print(betterIncrementString("foobar00999"))
}

fun incrementString(str: String): String {

    val result = str.firstOrNull { it.isDigit() && it != '0' }?.run {

        str.replaceRange(
            str.indexOf(this) until str.count(),
            (str.substring(str.indexOf(this) until str.count()).toInt() + 1).toString()
        )
    } ?: run {
        if (str.isNotEmpty() && str.last() == '0') {
            str.replaceRange((str.count() - 1) until str.count(), "1")
        } else "${str}1"
    }

    return if (result.count() > str.count()) {
        result.filter { it.isDigit() }.run {
            if ((this.toInt()).toString() != this) {
                result.indexOfFirst { it == '0' }.run {
                    result.removeRange(this..this)
                }
            } else result
        }
    } else result
}

fun betterIncrementString(str: String) : String {
    val i = str.takeLastWhile { it.isDigit() }
    return str.dropLast(i.length) + ((i.toIntOrNull() ?: 0) + 1).toString().padStart(i.length, '0')
}