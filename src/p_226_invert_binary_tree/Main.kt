package p_226_invert_binary_tree

// Problem link : https://leetcode.com/problems/invert-binary-tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()

    val root1 = TreeNode(4)
    root1.left = TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3)
    }
    root1.right = TreeNode(7).apply {
        left = TreeNode(6)
        right = TreeNode(9)
    }

    val inv1 = solution.invertTree(root1)
    println(listOf(
        inv1?.`val`,
        inv1?.left?.`val`, inv1?.right?.`val`,
        inv1?.left?.left?.`val`, inv1?.left?.right?.`val`,
        inv1?.right?.left?.`val`, inv1?.right?.right?.`val`
    ))

    val root2 = TreeNode(2)
    root2.left = TreeNode(1)
    root2.right = TreeNode(3)

    val inv2 = solution.invertTree(root2)
    println(listOf(inv2?.`val`, inv2?.left?.`val`, inv2?.right?.`val`))

    val root3: TreeNode? = null
    val inv3 = solution.invertTree(root3)
    println(if (inv3 == null) "[]" else listOf(inv3.`val`))
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