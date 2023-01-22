package kata

fun main() {
    val ys = CircularList(1, 2, 3, 4, 5)
    println(ys.next())
    println(ys.next())
    println(ys.prev())
    println(ys.prev())
    println(ys.next())
    println(ys.next())
    println(ys.next())
    println(ys.next())
    println(ys.prev())
    println(ys.prev())
    println(ys.next())
    println(ys.next())
    println(ys.next())
    println(ys.next())
    println(ys.next())
    println(ys.next())
}

class CircularList<T>(vararg val elements: T) {
    var index = 0
    var shouldDescreaseIndex = true

    init {
        if (elements.isEmpty()) throw Exception("No elements passed")
    }

    fun next(): T {
        if (index + 1 > elements.lastIndex) index = 0 else index++
        if (shouldDescreaseIndex) {
            index--
            shouldDescreaseIndex = false
        }
        return elements[index]
    }

    fun prev(): T {
        shouldDescreaseIndex = false
        if (index - 1 < 0) index = elements.lastIndex else index--
        return elements[index]
    }
}

