fun main() {
    print(rgb(0, 0, -20))
}

fun rgb(r: Int, g: Int, b: Int): String {

    val rr = if (r > 255) 255 else if (r < 0) 0 else r
    val gg = if (g > 255) 255 else if (g < 0) 0 else g
    val bb = if (b > 255) 255 else if (b < 0) 0 else b

    return String.format("%02x%02x%02x", rr, gg, bb).toUpperCase()
}

fun rgbBetter(r: Int, g: Int, b: Int) = String.format("%02X%02X%02X", r.coerceIn(0..255), g.coerceIn(0..255), b.coerceIn(0..255))
