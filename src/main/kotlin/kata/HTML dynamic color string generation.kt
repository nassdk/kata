import java.util.*

private const val COLORS = 256 * 256 * 256

fun main() {
    val rnd = Random()
    print(generateColor(rnd))
}

fun generateColor(r: Random) =
    String.format("#%02x%02x%02x", r.nextInt(255), r.nextInt(255), r.nextInt(255))


fun betterGenerateColor(r: Random): String = "#" + r.nextInt(COLORS).toString(16).padStart(6, '0')