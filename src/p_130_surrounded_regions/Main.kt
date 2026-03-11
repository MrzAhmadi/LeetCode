package p_130_surrounded_regions

// Problem link : https://leetcode.com/problems/surrounded-regions

fun main() {
    val solution = Solution()

    val board1 = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'O', 'X'),
        charArrayOf('X', 'O', 'X', 'X')
    )
    solution.solve(board1)
    board1.forEach { println(it.contentToString()) }

    val board2 = arrayOf(
        charArrayOf('X')
    )
    solution.solve(board2)
    board2.forEach { println(it.contentToString()) }
}

class Solution {
    fun solve(board: Array<CharArray>) {
        if (board.isEmpty() || board[0].isEmpty()) return

        val rows = board.size
        val cols = board[0].size

        for (r in 0..<rows) {
            if (board[r][0] == 'O') markSafe(board, r, 0, rows, cols)
            if (board[r][cols - 1] == 'O') markSafe(board, r, cols - 1, rows, cols)
        }

        for (c in 0..<cols) {
            if (board[0][c] == 'O') markSafe(board, 0, c, rows, cols)
            if (board[rows - 1][c] == 'O') markSafe(board, rows - 1, c, rows, cols)
        }

        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O'
                }
            }
        }
    }

    private fun markSafe(board: Array<CharArray>, r: Int, c: Int, rows: Int, cols: Int) {
        board[r][c] = 'T'

        if (r - 1 >= 0 && board[r - 1][c] == 'O') markSafe(board, r - 1, c, rows, cols)
        if (r + 1 < rows && board[r + 1][c] == 'O') markSafe(board, r + 1, c, rows, cols)
        if (c - 1 >= 0 && board[r][c - 1] == 'O') markSafe(board, r, c - 1, rows, cols)
        if (c + 1 < cols && board[r][c + 1] == 'O') markSafe(board, r, c + 1, rows, cols)
    }
}