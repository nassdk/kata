package codewars

fun main() {
    println(willYou(young = true, beautiful = true, loved = true))
}

fun willYou(young: Boolean, beautiful: Boolean, loved: Boolean): Boolean {
    return when {
        young && beautiful && loved -> false
        young && !beautiful && loved -> true
        !young && beautiful && loved -> true
        young && beautiful && !loved -> true
        !young && !beautiful && !loved -> false
        else -> false
    }
}