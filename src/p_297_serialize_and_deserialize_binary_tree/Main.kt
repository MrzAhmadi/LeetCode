package p_297_serialize_and_deserialize_binary_tree

import TreeNode

// Problem link : https://leetcode.com/problems/serialize-and-deserialize-binary-tree

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.right?.left = TreeNode(4)
    root.right?.right = TreeNode(5)

    val codec = Codec()

    val serializedData = codec.serialize(root)
    println(serializedData)

    val reconstructedTree = codec.deserialize(serializedData)

    val doubleCheckString = codec.serialize(reconstructedTree)
    println(doubleCheckString)
}

class Codec {

    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()

        fun dfs(node: TreeNode?) {
            if (node == null) {
                sb.append("#,")
                return
            }
            sb.append("${node.`val`},")
            dfs(node.left)
            dfs(node.right)
        }

        dfs(root)
        return sb.toString()
    }

    fun deserialize(data: String): TreeNode? {
        val tokens = data.split(",")
        var i = 0

        fun dfs(): TreeNode? {
            if (i >= tokens.size) return null

            val value = tokens[i++]
            if (value == "#" || value.isEmpty()) return null

            val node = TreeNode(value.toInt())
            node.left = dfs()
            node.right = dfs()
            return node
        }

        return dfs()
    }
}