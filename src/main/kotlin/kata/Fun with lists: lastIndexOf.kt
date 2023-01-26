package kata


fun main() {
    println(
        lastIndexOf(
            null, 17
        )
    )
}

fun listFromList(r: List<Any>): Node? = if (r.none()) null else Node(r[0], listFromList(r.drop(1)))

data class Node(val data: Any?, val next: Node? = null)

fun lastIndexOf(head: Node?, value: Any): Int {
    head ?: return -1
    val list = mutableListOf<Any>()
    list.add(head.data!!)
    var next: Node? = head.next
    do {
        list.add(next?.data!!)
        next = next.next
    } while (next != null)

    return list.lastIndexOf(value)
}

fun betterLastIndexOf(head: Node?, value: Any) = generateSequence(head) { it.next }.indexOfLast { it.data == value }
