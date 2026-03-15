package p_112_path_sum

import model.TreeNode

// Problem link : https://leetcode.com/problems/path-sum

fun main() {
    val solution = Solution()

    val root1 = TreeNode(5)
    root1.left = TreeNode(4).apply {
        left = TreeNode(11).apply {
            left = TreeNode(7)
            right = TreeNode(2)
        }
    }
    root1.right = TreeNode(8).apply {
        left = TreeNode(13)
        right = TreeNode(4).apply {
            right = TreeNode(1)
        }
    }
    println(solution.hasPathSum(root1, 22))

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)
    root2.right = TreeNode(3)
    println(solution.hasPathSum(root2, 5))

    val root3: TreeNode? = null
    println(solution.hasPathSum(root3, 0))
}

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null)
            return targetSum == root.`val`

        val remaining = targetSum - root.`val`
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining)
    }
}