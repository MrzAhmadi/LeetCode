package p_236_lowest_common_ancestor_of_a_binary_tree

import model.TreeNode

// Problem link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree

fun main() {
    val node3 = TreeNode(3)
    val node5 = TreeNode(5)
    val node1 = TreeNode(1)
    val node6 = TreeNode(6)
    val node2 = TreeNode(2)
    val node0 = TreeNode(0)
    val node8 = TreeNode(8)
    val node7 = TreeNode(7)
    val node4 = TreeNode(4)

    node3.left = node5
    node3.right = node1
    node5.left = node6
    node5.right = node2
    node1.left = node0
    node1.right = node8
    node2.left = node7
    node2.right = node4

    val solution = Solution()

    val result1 = solution.lowestCommonAncestor(node3, node5, node1)
    println(result1?.`val`)

    val result2 = solution.lowestCommonAncestor(node3, node5, node4)
    println(result2?.`val`)
}

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root === p || root === q) return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left != null && right != null) return root

        return left ?: right
    }
}