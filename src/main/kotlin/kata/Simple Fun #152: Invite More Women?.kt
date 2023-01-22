package kata

fun main() {
    val list = listOf(1, -1, 1)
    print(inviteMoreWomen(list))
//    print(list.groupBy { it }.)
}

fun inviteMoreWomen(l: List<Int>): Boolean {
    return l.groupBy { it }.run {
        (get(-1)?.size ?: 0) < (get(1)?.size ?: 0)
    }
}

fun betterInviteMoreWomen(l: List<Int>) = l.sum() > 0