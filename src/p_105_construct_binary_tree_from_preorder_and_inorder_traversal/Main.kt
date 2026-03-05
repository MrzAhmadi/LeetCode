package p_105_construct_binary_tree_from_preorder_and_inorder_traversal

import TreeNode

// Problem link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

fun main() {
    val solution = Solution2()

    val preorder1 = intArrayOf(3, 9, 20, 15, 7)
    val inorder1 = intArrayOf(9, 3, 15, 20, 7)
    println(solution.buildTree(preorder1, inorder1)?.toList())

    val preorder2 = intArrayOf(-1)
    val inorder2 = intArrayOf(-1)
    println(solution.buildTree(preorder2, inorder2)?.toList())
}

// The easiest solution O(N*2)
class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) return null

        val preorderRoot = preorder[0]
        val inorderRootIndex = inorder.indexOf(preorderRoot)

        val inorderLeftPart = inorder.copyOfRange(0, inorderRootIndex)
        val inorderRightPart = inorder.copyOfRange(inorderRootIndex + 1, inorder.size)

        val preorderLeftPart = preorder.copyOfRange(1, inorderLeftPart.size + 1)
        val preorderRightPart = preorder.copyOfRange(inorderLeftPart.size + 1, preorder.size)

        val root = TreeNode(preorderRoot)
        root.left = buildTree(preorderLeftPart, inorderLeftPart)
        root.right = buildTree(preorderRightPart, inorderRightPart)

        return root
    }
}

// The most optimal solution O(N)
class Solution2 {
    private var preorderIndex = 0
    private var inorderIndex = 0

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return build(preorder, inorder, null)
    }

    private fun build(preorder: IntArray, inorder: IntArray, stopValue: Int?): TreeNode? {
        if (preorderIndex >= preorder.size || (stopValue != null && inorder[inorderIndex] == stopValue)) return null

        val currentNode = TreeNode(preorder[preorderIndex++])

        currentNode.left = build(preorder, inorder, currentNode.`val`)
        inorderIndex++
        currentNode.right = build(preorder, inorder, stopValue)

        return currentNode
    }
}