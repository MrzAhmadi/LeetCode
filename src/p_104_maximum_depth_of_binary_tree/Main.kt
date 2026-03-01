package p_104_maximum_depth_of_binary_tree

import kotlin.math.max

// Problem link : https://leetcode.com/problems/maximum-depth-of-binary-tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()

    val root1 = TreeNode(3)
    root1.left = TreeNode(9)
    root1.right = TreeNode(20)
    root1.right?.left = TreeNode(15)
    root1.right?.right = TreeNode(7)
    println(solution.maxDepth(root1))

    val root2 = TreeNode(1)
    root2.right = TreeNode(2)
    println(solution.maxDepth(root2))
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = maxDepth(root.left)
        val right = maxDepth(root.right)
        return max(left, right) + 1
    }
}