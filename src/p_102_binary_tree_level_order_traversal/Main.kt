package p_102_binary_tree_level_order_traversal

import TreeNode

// Problem link : https://leetcode.com/problems/binary-tree-level-order-traversal

fun main() {
    val solution = Solution2()

    val root1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(solution.levelOrder(root1))

    val root2 = TreeNode(1)
    println(solution.levelOrder(root2))

    val root3: TreeNode? = null
    println(solution.levelOrder(root3))
}

// Standard BFS
class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val levelList = ArrayList<ArrayList<Int>>()
        if (root==null) return levelList

        val levelStack = ArrayDeque<TreeNode>()
        levelStack.add(root)

        while (levelStack.isNotEmpty()){

            val guestNodeCount = levelStack.size
            val guestNodeList = ArrayList<Int>()

            (0 ..<guestNodeCount).forEach { _ ->
                val current = levelStack.removeFirst()
                guestNodeList.add(current.`val`)
                current.left?.let { levelStack.add(it) }
                current.right?.let { levelStack.add(it) }
            }

            levelList.add(guestNodeList)

        }

        return levelList
    }
}

// Fastest DFS (Recursion)
class Solution2 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        dfs(root, 0, result)
        return result
    }

    private fun dfs(node: TreeNode?, level: Int, result: ArrayList<ArrayList<Int>>) {
        if (node == null) return

        if (level == result.size) {
            result.add(ArrayList())
        }

        result[level].add(node.`val`)

        dfs(node.left, level + 1, result)
        dfs(node.right, level + 1, result)
    }
}
