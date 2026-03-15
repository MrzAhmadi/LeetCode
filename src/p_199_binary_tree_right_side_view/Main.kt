package p_199_binary_tree_right_side_view

import model.TreeNode

// Problem link : https://leetcode.com/problems/binary-tree-right-side-view

fun main() {
    val solution = Solution2()

    val root1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            right = TreeNode(5)
        }
        right = TreeNode(3).apply {
            right = TreeNode(4)
        }
    }
    println(solution.rightSideView(root1))

    val root2 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(4).apply {
                left = TreeNode(5)
            }
        }
        right = TreeNode(3)
    }
    println(solution.rightSideView(root2))

    val root3 = TreeNode(1).apply {
        right = TreeNode(3)
    }
    println(solution.rightSideView(root3))

    val root4: TreeNode? = null
    println(solution.rightSideView(root4))
}

//Standard BFS
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val latestNodes = arrayListOf<Int>()
        if (root == null) return latestNodes

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {

            val stackSize = queue.size

            for (i in 0..<stackSize) {
                val current = queue.removeFirst()
                current.left?.let { queue.add(it) }
                current.right?.let { queue.add(it) }
                if (i == stackSize - 1)
                    latestNodes.add(current.`val`)
            }
        }
        return latestNodes
    }
}

//Fastest (DFS)
class Solution2 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = arrayListOf<Int>()
        dfs(root, 0, result)
        return result
    }

    private fun dfs(node: TreeNode?, depth: Int, result: ArrayList<Int>) {
        if (node == null) return

        if (depth == result.size) {
            result.add(node.`val`)
        }

        dfs(node.right, depth + 1, result)
        dfs(node.left, depth + 1, result)
    }
}