class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()

    fun graphToList(): List<List<Int>> {
        val node = this

        val visited = HashMap<Int, Node>()
        val queue = ArrayDeque<Node>()
        queue.add(node)
        visited[node.`val`] = node

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            for (neighbor in curr.neighbors) {
                if (neighbor != null && !visited.containsKey(neighbor.`val`)) {
                    visited[neighbor.`val`] = neighbor
                    queue.add(neighbor)
                }
            }
        }

        val result = mutableListOf<List<Int>>()
        for (i in 1..visited.size) {
            val curr = visited[i]
            if (curr != null) {
                result.add(curr.neighbors.map { it!!.`val` })
            } else {
                result.add(emptyList())
            }
        }

        return result
    }

    companion object {
        fun buildGraph(adjList: List<List<Int>>): Node? {
            if (adjList.isEmpty()) return null

            val nodes = HashMap<Int, Node>()
            for (i in 1..adjList.size) {
                nodes[i] = Node(i)
            }

            for (i in adjList.indices) {
                val neighbors = adjList[i]
                for (n in neighbors) {
                    nodes[i + 1]?.neighbors?.add(nodes[n])
                }
            }
            return nodes[1]
        }
    }

}