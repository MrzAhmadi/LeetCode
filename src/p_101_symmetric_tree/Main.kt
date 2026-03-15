package p_101_symmetric_tree

import model.TreeNode

// Problem link : https://leetcode.com/problems/symmetric-tree

fun main() {
    val solution = Solution()

    val root1 = TreeNode(1)
    root1.left = TreeNode(2).apply {
        left = TreeNode(3)
        right = TreeNode(4)
    }
    root1.right = TreeNode(2).apply {
        left = TreeNode(4)
        right = TreeNode(3)
    }
    println(solution.isSymmetric(root1))

    val root2 = TreeNode(1)
    root2.left = TreeNode(2).apply {
        right = TreeNode(3)
    }
    root2.right = TreeNode(2).apply {
        right = TreeNode(3)
    }
    println(solution.isSymmetric(root2))
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) return true
        return isMirror(root.left, root.right)
    }

    private fun isMirror(leftNode: TreeNode?, rightNode: TreeNode?): Boolean {
        if (leftNode == null && rightNode == null) return true
        if (leftNode == null || rightNode == null) return false
        if (leftNode.`val` != rightNode.`val`) return false
        return isMirror(leftNode.left, rightNode.right) && isMirror(leftNode.right, rightNode.left)
    }
}