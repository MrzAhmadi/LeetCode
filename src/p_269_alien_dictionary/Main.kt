package p_269_alien_dictionary

// Problem link : https://leetcode.com/problems/alien-dictionary

fun main() {
    val solution = Solution()

    val words1 = arrayOf("z", "o")
    println(solution.foreignDictionary(words1))

    val words2 = arrayOf("hrn", "hrf", "er", "enn", "rfnn")
    println(solution.foreignDictionary(words2))

    val words3 = arrayOf("z", "x", "z")
    println(solution.foreignDictionary(words3))
}

class Solution {
    fun foreignDictionary(words: Array<String>): String {
        val adj = Array(26) { BooleanArray(26) }
        val inDegree = IntArray(26) { -1 }
        var uniqueChars = 0

        for (word in words) {
            for (char in word) {
                val idx = char - 'a'
                if (inDegree[idx] == -1) {
                    inDegree[idx] = 0
                    uniqueChars++
                }
            }
        }

        for (i in 0..<words.size - 1) {
            val w1 = words[i]
            val w2 = words[i + 1]
            val minLen = minOf(w1.length, w2.length)

            if (w1.length > w2.length && w1.startsWith(w2)) {
                return ""
            }

            for (j in 0..<minLen) {
                val c1 = w1[j] - 'a'
                val c2 = w2[j] - 'a'
                if (c1 != c2) {
                    if (!adj[c1][c2]) {
                        adj[c1][c2] = true
                        inDegree[c2]++
                    }
                    break
                }
            }
        }

        val queue = IntArray(26)
        var head = 0
        var tail = 0

        for (i in 0 until 26) {
            if (inDegree[i] == 0) {
                queue[tail++] = i
            }
        }

        val sb = java.lang.StringBuilder()
        while (head < tail) {
            val curr = queue[head++]
            sb.append((curr + 'a'.code).toChar())

            for (next in 0 until 26) {
                if (adj[curr][next]) {
                    inDegree[next]--
                    if (inDegree[next] == 0) {
                        queue[tail++] = next
                    }
                }
            }
        }

        return if (sb.length == uniqueChars) sb.toString() else ""
    }
}