package p_100_same_tree

// Problem link : https://leetcode.com/problems/same-tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()

    val p1 = TreeNode(1)
    p1.left = TreeNode(2)
    p1.right = TreeNode(3)

    val q1 = TreeNode(1)
    q1.left = TreeNode(2)
    q1.right = TreeNode(3)

    println(solution.isSameTree(p1, q1))

    val p2 = TreeNode(1)
    p2.left = TreeNode(2)

    val q2 = TreeNode(1)
    q2.right = TreeNode(2)

    println(solution.isSameTree(p2, q2))

    val p3 = TreeNode(1)
    p3.left = TreeNode(2)
    p3.right = TreeNode(1)

    val q3 = TreeNode(1)
    q3.left = TreeNode(1)
    q3.right = TreeNode(2)

    println(solution.isSameTree(p3, q3))
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) return true
        if (p == null || q == null) return false
        if (p.`val` != q.`val`) return false
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}