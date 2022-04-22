package codewars

fun main() {
    println(longest("loopingisfunbutdangerous", "lessdangerousthancoding"))
}

fun longest(s1: String, s2: String): String {
    return buildString {
        append(s1)
        append(s2)
    }.toMutableList().distinct().sorted().joinToString("")
}

fun betterLongest(s1:String, s2:String):String {
    return (s1 + s2).toSortedSet().joinToString("")
}