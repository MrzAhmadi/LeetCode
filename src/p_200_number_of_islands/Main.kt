package p_200_number_of_islands

// Problem link : https://leetcode.com/problems/number-of-islands

fun main() {
    val solution = Solution()

    val grid1 = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(solution.numIslands(grid1))

    val grid2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    println(solution.numIslands(grid2))
}

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0

        var islandCount = 0
        val rows = grid.size
        val cols = grid[0].size

        for (r in 0..<rows) {
            for (c in 0..<cols) {
                if (grid[r][c] == '1') {
                    islandCount++
                    sinkIsland(grid, r, c, rows, cols)
                }
            }
        }

        return islandCount
    }

    private fun sinkIsland(grid: Array<CharArray>, r: Int, c: Int, rows: Int, cols: Int) {
        grid[r][c] = '0'

        if (r - 1 >= 0 && grid[r - 1][c] == '1') sinkIsland(grid, r - 1, c, rows, cols)
        if (r + 1 < rows && grid[r + 1][c] == '1') sinkIsland(grid, r + 1, c, rows, cols)
        if (c - 1 >= 0 && grid[r][c - 1] == '1') sinkIsland(grid, r, c - 1, rows, cols)
        if (c + 1 < cols && grid[r][c + 1] == '1') sinkIsland(grid, r, c + 1, rows, cols)
    }
}