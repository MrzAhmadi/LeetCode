package p_428_serialize_and_deserialize_n_ary_tree

import model.NodeNary

// Problem link : https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree

fun main() {
    val root = NodeNary(1)
    val child2 = NodeNary(2)
    val child3 = NodeNary(3)
    val child4 = NodeNary(4)
    val child5 = NodeNary(5)
    val child6 = NodeNary(6)

    // Building the N-ary tree
    root.children.add(child2)
    root.children.add(child3)
    root.children.add(child4)
    child3.children.add(child5)
    child3.children.add(child6)

    val codec = Codec()

    val serializedData = codec.serialize(root)
    println(serializedData)

    val reconstructedTree = codec.deserialize(serializedData)

    val doubleCheckString = codec.serialize(reconstructedTree)
    println(doubleCheckString)
}

class Codec {

    fun serialize(root: NodeNary?): String {
        if (root == null) return ""
        val sb = StringBuilder()

        fun dfs(node: NodeNary) {
            sb.append("${node.`val`},")
            for (child in node.children) {
                dfs(child)
            }
            sb.append("#,")
        }

        dfs(root)
        return sb.toString()
    }

    fun deserialize(data: String): NodeNary? {
        if (data.isEmpty()) return null

        val tokens = data.split(",")
        var i = 0

        fun dfs(): NodeNary {
            val node = NodeNary(tokens[i++].toInt())

            while (tokens[i] != "#") {
                node.children.add(dfs())
            }
            i++
            return node
        }

        return dfs()
    }
}