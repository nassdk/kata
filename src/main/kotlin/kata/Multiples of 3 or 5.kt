fun main() {
    print(betterSolution(200))
}

fun solution(number: Int): Int {

    var sum = 0
    var n = 0

    while (n < number) {

        if (n % 3 == 0 || n % 5 == 0)
            sum += n

        n++
    }

    return sum
}

fun betterSolution(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()