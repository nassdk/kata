package kata

fun main() {
    println(argsCount(1,2,3,4,5))
}
fun argsCount(vararg args: Any): Int {
    return args.size
}