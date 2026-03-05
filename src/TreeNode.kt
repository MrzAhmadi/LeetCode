class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun toList(): List<Int?> {
        val result = mutableListOf<Int?>()
        val queue = ArrayDeque<TreeNode?>()
        queue.add(this)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            if (node != null) {
                result.add(node.`val`)
                queue.add(node.left)
                queue.add(node.right)
            } else {
                result.add(null)
            }
        }

        while (result.isNotEmpty() && result.last() == null) {
            result.removeLast()
        }

        return result
    }
}