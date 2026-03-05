package p_114_flatten_binary_tree_to_linked_list

import TreeNode

// Problem link : https://leetcode.com/problems/flatten-binary-tree-to-linked-list

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