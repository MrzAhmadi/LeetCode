package p_684_redundant_connection

// Problem link : https://leetcode.com/problems/redundant-connection

fun main() {
    val solution = Solution()

    val edges1 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 3)
    )
    println(solution.findRedundantConnection(edges1).contentToString())

    val edges2 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(1, 4),
        intArrayOf(1, 5)
    )
    println(solution.findRedundantConnection(edges2).contentToString())
}

class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val parent = IntArray(edges.size + 1) {
            it
        }

        fun find(i: Int): Int {
            var root = i
            while (root != parent[root]) {
                parent[root] = parent[parent[root]]
                root = parent[root]
            }
            return root
        }

        for (edge in edges) {
            val root1 = find(edge[0])
            val root2 = find(edge[1])

            if (root1 == root2) {
                return edge
            }

            parent[root1] = root2
        }

        return intArrayOf()
    }
}