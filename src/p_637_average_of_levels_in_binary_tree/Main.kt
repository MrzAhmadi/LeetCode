package p_637_average_of_levels_in_binary_tree

import TreeNode

// Problem link : https://leetcode.com/problems/average-of-levels-in-binary-tree

fun main() {
    val solution = Solution()

    val root1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(solution.averageOfLevels(root1).contentToString())

    val root2 = TreeNode(3).apply {
        left = TreeNode(9).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
        right = TreeNode(20)
    }
    println(solution.averageOfLevels(root2).contentToString())
}

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val averageList = arrayListOf<Double>()
        if (root == null) return averageList.toDoubleArray()

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var rowSum = 0.0

            (0..<levelSize).forEach { _ ->
                val current = queue.removeFirst()
                rowSum += current.`val`

                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
            }

            averageList.add(rowSum / levelSize)
        }

        return averageList.toDoubleArray()
    }
}