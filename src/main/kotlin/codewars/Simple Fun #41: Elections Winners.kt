package codewars

fun main() {
    // 5, 6, 8, 5
    println(electionsWinners(arrayOf(5, 1, 3, 4, 1), 0))
}

fun electionsWinners(votes: Array<Int>, k: Int): Int {
    val max = votes.maxOf { it }
    return if (k == 0) {
        if (votes.count { it == max } > 1) 0 else 1
    } else {
        votes.filter { it + k > max }.size
    }
}

fun betterElectionsWinners(votes: Array<Int>, k: Int): Int {
    val maks = votes.maxOf { it }
    if(k == 0){
        return if(votes.count{it == maks} > 1) 0
        else 1
    }
    return votes.count { it + k > maks }
}