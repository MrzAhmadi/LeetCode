package p_133_clone_graph

import Node
import Node.Companion.buildGraph

// Problem link : https://leetcode.com/problems/clone-graph

fun main() {
    val solution = Solution()

    val adjList1 = listOf(listOf(2, 4), listOf(1, 3), listOf(2, 4), listOf(1, 3))
    val graph1 = buildGraph(adjList1)
    val clone1 = solution.cloneGraph(graph1)
    println(clone1?.graphToList())

    val adjList2 = listOf(emptyList<Int>())
    val graph2 = buildGraph(adjList2)
    val clone2 = solution.cloneGraph(graph2)
    println(clone2?.graphToList())

    val adjList3 = emptyList<List<Int>>()
    val graph3 = buildGraph(adjList3)
    val clone3 = solution.cloneGraph(graph3)
    println(clone3?.graphToList())
}

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val visited = HashMap<Node, Node>()

        fun dfs(currentNode: Node?): Node? {
            if (currentNode == null) return null
            if (visited.containsKey(currentNode)) return visited[currentNode]

            val cloneNode = Node(currentNode.`val`)
            visited[currentNode] = cloneNode

            for (neighbor in currentNode.neighbors) {
                cloneNode.neighbors.add(dfs(neighbor))
            }

            return cloneNode
        }

        return dfs(node)
    }
}