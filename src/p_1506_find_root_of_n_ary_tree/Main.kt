package p_1506_find_root_of_n_ary_tree

import model.NodeNary

// Problem link : https://leetcode.com/problems/find-root-of-n-ary-tree

fun main() {
    val node1 = NodeNary(1)
    val node2 = NodeNary(2)
    val node3 = NodeNary(3)
    val node4 = NodeNary(4)
    val node5 = NodeNary(5)

    node1.children.add(node2)
    node1.children.add(node3)
    node1.children.add(node4)
    node2.children.add(node5)

    val treeList = listOf(node4, node2, node5, node1, node3)

    val solution = Solution()
    val root = solution.findRoot(treeList)

    println(root?.`val`)
}

class Solution {
    fun findRoot(tree: List<NodeNary>): NodeNary? {
        var sum = 0L

        for (node in tree) {
            sum += node.`val`
            for (child in node.children) {
                sum -= child.`val`
            }
        }

        for (node in tree) {
            if (node.`val`.toLong() == sum) {
                return node
            }
        }

        return null
    }
}