package kata

fun main() {
    print(hexStringToRGB("#FF9933"))
}

data class RGB(val r: Int, val g: Int, val b: Int)

fun hexStringToRGB(hexString: String) = RGB(
    r = Integer.valueOf(hexString.substring(1, 3), 16),
    g = Integer.valueOf(hexString.substring(3, 5), 16),
    b = Integer.valueOf(hexString.substring(5, 7), 16)
)

fun betterHexStringToRGB(hexString: String) = hexString.drop(1).chunked(2) { "$it".toInt(16) }.let { RGB(it[0], it[1], it[2]) }