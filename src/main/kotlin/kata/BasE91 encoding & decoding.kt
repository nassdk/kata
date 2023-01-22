package kata

fun main() {

}

fun isCheck(board: Array<Array<String>>): Boolean {

    board.forEachIndexed { i, line ->
        line.forEachIndexed { index, figure ->
            if (figure.isNotBlank()) {
                return when (figure) {
                    "♛" -> line.contains("♔")
                    "♜" -> line.contains("♔") || doesRookCheck(board, index)
                    "♞" -> doesKnightCheck(board, index, i)
                    "♝" -> false
                    "♟" -> doesPawnCheck(board, index, i)
                    else -> false
                }
            }
        }
    }
    return false
}

private fun doesKnightCheck(b: Array<Array<String>>, ix: Int, iy: Int): Boolean {
    val knightAttackTargets = listOf(
        ix + 2 to iy + 1,
        ix + 2 to iy - 1,
        ix + 1 to iy + 2,
        ix + 1 to iy - 2,
        ix - 2 to iy + 1,
        ix - 2 to iy - 1,
        ix - 1 to iy + 2,
        ix - 1 to iy - 2,
    ).filter { it.first < 8 && it.second < 8 }

    return knightAttackTargets.any { b[it.second][it.first] == "♔" }
}

private fun doesRookCheck(b: Array<Array<String>>, i: Int) = b.any { it[i] == "♔" }
private fun doesPawnCheck(b: Array<Array<String>>, ix: Int, iy: Int): Boolean {
    return b[iy].run {
        getOrNull(ix + 1) == "♔" || getOrNull(ix - 1) == "♔"
    }
}

val kingFigure = "♔"
val queenFigure = "♛"
val biahopFigure = "♝"
val knightFigure = "♞"
val rookFigure = "♜"
val pawnFigure = "♟"
