fun main() {
    println(findShort("bitcoin take over the world maybe who knows perhaps"))
}

//fun findShort(s: String) = s.split(" ").minByOrNull { it.length }?.length ?: 0
fun findShort(s: String) = s.split(" ").minByOrNull { it.length }?.length ?: 0