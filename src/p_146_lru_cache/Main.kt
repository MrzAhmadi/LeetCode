package p_146_lru_cache

// Problem link : https://leetcode.com/problems/lru-cache

fun main() {
    val lruCache = LRUCache(2)

    lruCache.put(1, 1)
    lruCache.put(2, 2)
    println(lruCache.get(1))

    lruCache.put(3, 3)
    println(lruCache.get(2))

    lruCache.put(4, 4)
    println(lruCache.get(1))
    println(lruCache.get(3))
    println(lruCache.get(4))
}

class LRUCache(private val capacity: Int) {

    private inner class Node(val key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private val map = HashMap<Int, Node>()
    private val head = Node(0, 0)
    private val tail = Node(0, 0)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToFront(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val existingNode = map[key]

        if (existingNode != null) {
            existingNode.value = value
            moveToFront(existingNode)
        } else {
            val newNode = Node(key, value)
            map[key] = newNode
            addToFront(newNode)

            if (map.size > capacity) {
                val lruNode = removeLast()
                map.remove(lruNode.key)
            }
        }
    }

    private fun addToFront(node: Node) {
        node.prev = head
        node.next = head.next
        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun moveToFront(node: Node) {
        removeNode(node)
        addToFront(node)
    }

    private fun removeLast(): Node {
        val lruNode = tail.prev!!
        removeNode(lruNode)
        return lruNode
    }
}
