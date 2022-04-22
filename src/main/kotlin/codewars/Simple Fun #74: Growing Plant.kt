package codewars

fun main() {
    print(growingPlant(10, 9, 4))
}

fun growingPlant(upSpeed: Int, downSpeed: Int, desiredHeight: Int): Int {
    if (upSpeed >= desiredHeight) return 1
    val x = (desiredHeight - downSpeed) / (upSpeed - downSpeed)
    val mod = (desiredHeight - downSpeed) % (upSpeed - downSpeed)
    return if (mod == 0) x else x + 1
}