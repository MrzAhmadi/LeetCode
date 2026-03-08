package p_103_binary_tree_zigzag_level_order_traversal

import TreeNode
import java.util.LinkedList

// Problem link : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

fun main() {
    val solution = Solution2()

    val root1 = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(solution.zigzagLevelOrder(root1))

    val root2 = TreeNode(1)
    println(solution.zigzagLevelOrder(root2))

    val root3: TreeNode? = null
    println(solution.zigzagLevelOrder(root3))
}

// Standard BFS
class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if (root == null) return result

        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var leftToRight = true

        while (queue.isNotEmpty()) {

            val levelSize = queue.size
            val currentLevel = LinkedList<Int>()

            (0..<levelSize).forEach { _ ->
                val node = queue.removeFirst()

                if (leftToRight) {
                    currentLevel.addLast(node.`val`)
                } else {
                    currentLevel.addFirst(node.`val`)
                }

                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }

            }

            result.add(currentLevel)
            leftToRight = !leftToRight
        }

        return result
    }
}

// Fastest DFS (Recursion)
class Solution2 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<LinkedList<Int>>()

        fun addNode(node: TreeNode?, level: Int) {
            if (node == null) return

            if (level == result.size) {
                result.add(LinkedList())
            }

            if (level % 2 == 0) {
                result[level].addLast(node.`val`)
            } else {
                result[level].addFirst(node.`val`)
            }

            addNode(node.left, level + 1)
            addNode(node.right, level + 1)
        }

        addNode(root, 0)
        return result
    }
}