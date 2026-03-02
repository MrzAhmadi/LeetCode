package p_226_invert_binary_tree

// Problem link : https://leetcode.com/problems/invert-binary-tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val temp = root.left
        root.left = root.right
        root.right = temp

        invertTree(root.left)
        invertTree(root.right)

        return root
    }
}