package codewars

fun main() {
    println(Solution.nameValue(arrayOf("abc", "abc abc")))
}

object Solution {

    fun nameValue(arr: Array<String>): IntArray {

        return arr.mapIndexed { index, s ->
            s.map { char ->
                "abcdefghijklmnopqrstuvwxyz".indexOf(char) + 1
            }.sum() * (index + 1)
        }.toIntArray()
    }

    fun betterNameValue(arr: Array<String>) = arr.mapIndexed { i, s -> s.replace(" ", "").sumBy { it.toInt() - 96 } * (i + 1) }.toIntArray()

}