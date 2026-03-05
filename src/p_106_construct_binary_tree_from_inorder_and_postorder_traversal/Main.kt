package p_106_construct_binary_tree_from_inorder_and_postorder_traversal

import TreeNode

// Problem link : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal

fun main() {
    val solution = Solution2()

    val inorder1 = intArrayOf(9, 3, 15, 20, 7)
    val postorder1 = intArrayOf(9, 15, 7, 20, 3)
    println(solution.buildTree(inorder1, postorder1)?.toList())

    val inorder2 = intArrayOf(-1)
    val postorder2 = intArrayOf(-1)
    println(solution.buildTree(inorder2, postorder2)?.toList())
}

// The easiest solution O(N*2)
class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty() || postorder.isEmpty()) return null

        val rootVal = postorder.last()
        val rootIndex = inorder.indexOf(rootVal)

        val inorderLeft = inorder.copyOfRange(0, rootIndex)
        val inorderRight = inorder.copyOfRange(rootIndex + 1, inorder.size)

        val postorderLeft = postorder.copyOfRange(0, inorderLeft.size)
        val postorderRight = postorder.copyOfRange(inorderLeft.size, postorder.size - 1)

        val root = TreeNode(rootVal)
        root.left = buildTree(inorderLeft, postorderLeft)
        root.right = buildTree(inorderRight, postorderRight)

        return root
    }
}

// The most optimal solution O(N)
class Solution2 {
    private var postorderIndex = 0
    private var inorderIndex = 0

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {

        postorderIndex = postorder.size - 1
        inorderIndex = inorder.size - 1
        return build(inorder, postorder, null)
    }

    private fun build(inorder: IntArray, postorder: IntArray, stopValue: Int?): TreeNode? {
        if (postorderIndex < 0 || (stopValue != null && inorder[inorderIndex] == stopValue)) return null

        val currentNode = TreeNode(postorder[postorderIndex--])

        currentNode.right = build(inorder, postorder, currentNode.`val`)

        inorderIndex--

        currentNode.left = build(inorder, postorder, stopValue)

        return currentNode
    }
}