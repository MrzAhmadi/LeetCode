package p_543_diameter_of_binary_tree

import model.TreeNode

// Problem link : https://leetcode.com/problems/diameter-of-binary-tree

fun main() {
    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)
    root1.left?.left = TreeNode(4)
    root1.left?.right = TreeNode(5)

    val solution1 = Solution()
    val result1 = solution1.diameterOfBinaryTree(root1)
    println(result1)

    val root2 = TreeNode(1)
    root2.left = TreeNode(2)

    val solution2 = Solution()
    val result2 = solution2.diameterOfBinaryTree(root2)
    println(result2)
}

class Solution {

    private var maxDiameter = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxDiameter
    }

    private fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        val leftDepth = dfs(node.left)
        val rightDepth = dfs(node.right)

        val localDiameter = leftDepth + rightDepth
        if (localDiameter > maxDiameter) {
            maxDiameter = localDiameter
        }

        return maxOf(leftDepth, rightDepth) + 1
    }
}