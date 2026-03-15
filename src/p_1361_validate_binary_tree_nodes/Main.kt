package p_1361_validate_binary_tree_nodes

// Problem link : https://leetcode.com/problems/validate-binary-tree-nodes

fun main() {
    val solution = Solution()

    val left1 = intArrayOf(1, -1, 3, -1)
    val right1 = intArrayOf(2, -1, -1, -1)
    println(solution.validateBinaryTreeNodes(4, left1, right1))

    val left2 = intArrayOf(1, -1, 3, -1)
    val right2 = intArrayOf(2, 3, -1, -1)
    println(solution.validateBinaryTreeNodes(4, left2, right2))
}

class Solution {
    fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
        val isChild = BooleanArray(n)

        for (i in leftChild) {
            if (i != -1) {
                isChild[i] = true
            }
        }

        for (i in rightChild) {
            if (i != -1) {
                if (isChild[i]) {
                    return false
                }
                isChild[i] = true
            }
        }

        var root = -1
        for (i in 0 until n) {
            if (!isChild[i]) {
                if (root == -1) {
                    root = i
                } else {
                    return false
                }
            }
        }

        if (root == -1) return false

        val toVisit = isChild
        toVisit[root] = true
        var visitCount = 0

        val stack = IntArray(n)
        stack[0] = root
        var count = 1

        while (count > 0) {
            val node = stack[--count]

            if (!toVisit[node]) {
                return false
            }

            toVisit[node] = false
            visitCount++

            val left = leftChild[node]
            if (left >= 0) {
                stack[count++] = left
            }

            val right = rightChild[node]
            if (right >= 0) {
                stack[count++] = right
            }
        }

        return visitCount == n
    }
}