package p_129_sum_root_to_leaf_numbers

import TreeNode

// Problem link : https://leetcode.com/problems/sum-root-to-leaf-numbers/description

fun main() {
    val solution = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    }
    println(solution.sumNumbers(root1))

    val root2 = TreeNode(4).apply {
        left = TreeNode(9).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        }
        right = TreeNode(0)
    }
    println(solution.sumNumbers(root2))
}

class Solution {
    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    private fun dfs(node: TreeNode?, currentSum: Int): Int {
        if (node == null) return 0

        val nextSum = currentSum * 10 + node.`val`

        if (node.left == null && node.right == null) {
            return nextSum
        }

        return dfs(node.left, nextSum) + dfs(node.right, nextSum)
    }
}