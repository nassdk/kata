package codewars

fun main() {

}

fun smallEnough(a : IntArray, limit : Int) : Boolean {
    return a.all { it <= limit }
}