package p_242_valid_anagram

// Problem link : https://leetcode.com/problems/valid-anagram

fun main() {
    val solution = Solution()
    println(solution.isAnagram("anagram", "nagaram"))
    println(solution.isAnagram("rat", "car"))
}

class Solution {
    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) return false

        val sMap = hashMapOf<Char, Int>()

        for (i in 0..<s.length) {
            val currentS = s[i]
            if (!sMap.contains(currentS))
                sMap[currentS] = 1
            else
                sMap[currentS] = sMap[currentS]!!.plus(1)
        }

        for (i in 0..<t.length) {
            val currentT = t[i]
            if (!sMap.contains(currentT))
                return false
            val newCount = sMap[currentT]!!.minus(1)
            if (newCount < 0)
                return false
            sMap[currentT] = newCount
        }

        return true
    }
}