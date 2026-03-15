package p_98_validate_binary_search_tree

import model.TreeNode

// Problem link : https://leetcode.com/problems/validate-binary-search-tree

fun main() {
    val root1 = TreeNode(2)
    root1.left = TreeNode(1)
    root1.right = TreeNode(3)

    val solution1 = Solution()
    println(solution1.isValidBST(root1))

    val root2 = TreeNode(5)
    root2.left = TreeNode(1)
    root2.right = TreeNode(4)
    root2.right?.left = TreeNode(3)
    root2.right?.right = TreeNode(6)

    val solution2 = Solution()
    println(solution2.isValidBST(root2))

    val root3 = TreeNode(5)
    root3.left = TreeNode(4)
    root3.right = TreeNode(6)
    root3.right?.left = TreeNode(3)
    root3.right?.right = TreeNode(7)

    val solution3 = Solution()
    println(solution3.isValidBST(root3))
}

class Solution {
    private var prev: TreeNode? = null

    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true

        if (!isValidBST(root.left)) return false

        if (prev != null && root.`val` <= prev!!.`val`) return false
        prev = root

        return isValidBST(root.right)
    }
}

class Solution2 {
    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun dfs(node: TreeNode?, min: Long, max: Long): Boolean {
        node ?: return true

        if (node.`val` <= min || node.`val` >= max) return false

        val limit = node.`val`.toLong()
        return dfs(node.left, min, limit) && dfs(node.right, limit, max)
    }
}