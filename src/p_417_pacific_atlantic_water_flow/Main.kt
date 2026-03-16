package p_417_pacific_atlantic_water_flow

// Problem link : https://leetcode.com/problems/pacific-atlantic-water-flow

fun main() {
    val solution = Solution()

    val heights1 = arrayOf(
        intArrayOf(1, 2, 2, 3, 5),
        intArrayOf(3, 2, 3, 4, 4),
        intArrayOf(2, 4, 5, 3, 1),
        intArrayOf(6, 7, 1, 4, 5),
        intArrayOf(5, 1, 1, 2, 4)
    )
    println(solution.pacificAtlantic(heights1))

    val heights2 = arrayOf(
        intArrayOf(1)
    )
    println(solution.pacificAtlantic(heights2))
}

class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val m = heights.size
        val n = heights[0].size
        val pacific = Array(m) { BooleanArray(n) }
        val atlantic = Array(m) { BooleanArray(n) }

        for (i in 0..<m) {
            dfs(heights, pacific, i, 0, -1)
            dfs(heights, atlantic, i, n - 1, -1)
        }
        for (j in 0..<n) {
            dfs(heights, pacific, 0, j, -1)
            dfs(heights, atlantic, m - 1, j, -1)
        }

        val result = mutableListOf<List<Int>>()
        for (i in 0..<m) {
            for (j in 0..<n) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }

        return result
    }

    private fun dfs(heights: Array<IntArray>, visited: Array<BooleanArray>, r: Int, c: Int, prevHeight: Int) {
        if (r < 0 || r >= heights.size || c < 0 || c >= heights[0].size) return
        if (visited[r][c] || heights[r][c] < prevHeight) return

        visited[r][c] = true
        val currentHeight = heights[r][c]

        dfs(heights, visited, r + 1, c, currentHeight)
        dfs(heights, visited, r - 1, c, currentHeight)
        dfs(heights, visited, r, c + 1, currentHeight)
        dfs(heights, visited, r, c - 1, currentHeight)
    }
}