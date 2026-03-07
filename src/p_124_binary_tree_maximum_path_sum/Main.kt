package p_124_binary_tree_maximum_path_sum

import TreeNode

// Problem link : https://leetcode.com/problems/binary-tree-maximum-path-sum

fun main() {
    val solution = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    println(solution.maxPathSum(root1))

    val root2 = TreeNode(-10).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(solution.maxPathSum(root2))
}

class Solution {
    private var maxSum = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        maxSum = Int.MIN_VALUE
        dfs(root)
        return maxSum
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val leftMax = maxOf(dfs(node.left), 0)
        val rightMax = maxOf(dfs(node.right), 0)

        maxSum = maxOf(maxSum, node.`val` + leftMax + rightMax)

        return node.`val` + maxOf(leftMax, rightMax)
    }
}