package kata

fun main() {

}

object DoubleSort {
    fun dbSort(a:Array<Any>):Array<Any> {
        val letters = a.filterIsInstance<String>().sorted()
        val numbers = a.filterIsInstance<Int>().sorted()
        val result = arrayListOf<Any>()
        result.addAll(numbers)
        result.addAll(letters)
        return result.toTypedArray()
    }

    fun betterDbSort(a: Array<Any>): Array<Any> {
        return ((a.filter { Int::class.isInstance(it) } as List<Int>).sorted() + (a.filter { String::class.isInstance(it) } as List<String>).sorted()).toTypedArray()
    }

    fun better2DbSort(a: Array<Any>): Array<Any> = (a.filterIsInstance<Int>().sortedBy { it } + a.filterIsInstance<String>().sorted()).toTypedArray()
}

