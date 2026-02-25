package p_383_ransom_note

// Problem link : https://leetcode.com/problems/ransom-note

fun main() {
    val solution = Solution()
    println(solution.canConstruct(ransomNote = "a", magazine = "b"))
    println(solution.canConstruct(ransomNote = "aa", magazine = "ab"))
    println(solution.canConstruct(ransomNote = "aa", magazine = "aab"))
}

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) return false

        val charCounts = IntArray(26)

        for (char in magazine) {
            charCounts[char - 'a']++
        }

        for (char in ransomNote) {
            val index = char - 'a'
            if (charCounts[index] == 0) {
                return false
            }
            charCounts[index]--
        }

        return true
    }
}