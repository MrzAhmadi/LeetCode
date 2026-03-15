package p_114_flatten_binary_tree_to_linked_list

import model.TreeNode

// Problem link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list

fun main() {
    val solution = Solution()

    val root1 = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(4)
        }
        right = TreeNode(5).apply {
            right = TreeNode(6)
        }
    }
    solution.flatten(root1)
    println(root1.toList())

    val root2: TreeNode? = null
    solution.flatten(root2)
//    println(root2.toList())

    val root3 = TreeNode(0)
    solution.flatten(root3)
    println(root3.toList())
}

class Solution {
    fun flatten(root: TreeNode?) {
        if(root == null)
            return

        flatten(root.left)
        flatten(root.right)

        if (root.left != null) {
            val tempRight = root.right

            root.right = root.left
            root.left = null

            var tail = root.right
            while (tail?.right != null) {
                tail = tail.right
            }

            tail?.right = tempRight
        }
    }
}