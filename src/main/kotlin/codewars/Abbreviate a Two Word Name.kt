package codewars

fun main() {
    println(abbrevName("Sam Harris"))
}
fun abbrevName(name:String): String {
    return name.split(" ").joinToString(".") {
        it.take(1).capitalize()
    }
}