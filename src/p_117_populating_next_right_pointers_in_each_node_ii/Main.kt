package p_117_populating_next_right_pointers_in_each_node_ii

// Problem link : https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null

        root.left?.next = root.right ?: findNextChild(root.next)
        root.right?.next = findNextChild(root.next)

        connect(root.right)
        connect(root.left)

        return root
    }

    private fun findNextChild(node: Node?): Node? {
        if (node == null) return null
        return node.left ?: node.right ?: findNextChild(node.next)
    }
}