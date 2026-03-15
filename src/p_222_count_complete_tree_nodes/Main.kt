package p_222_count_complete_tree_nodes

import model.TreeNode

// Problem link : https://leetcode.com/problems/count-complete-tree-nodes

fun main() {
    val solution = Solution()

    val root1 = TreeNode(1)
    root1.left = TreeNode(2).apply {
        left = TreeNode(4)
        right = TreeNode(5)
    }
    root1.right = TreeNode(3).apply {
        left = TreeNode(6)
    }
    println(solution.countNodes(root1))

    val root2: TreeNode? = null
    println(solution.countNodes(root2))

    val root3 = TreeNode(1)
    println(solution.countNodes(root3))
}

class Solution {
    fun countNodes(root: TreeNode?): Int {
        if (root == null)
            return 0
        return countNodes(root.left) + countNodes(root.right) + 1
    }
}