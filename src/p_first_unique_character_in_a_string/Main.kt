package p_first_unique_character_in_a_string

// Problem link : https://leetcode.com/problems/first-unique-character-in-a-string

fun main() {
    val solution = Solution()

    println(solution.firstUniqChar("leetcode"))
    println(solution.firstUniqChar("loveleetcode"))
    println(solution.firstUniqChar("aabb"))
}

// Map
class Solution {
    fun firstUniqChar(s: String): Int {
        val map = HashMap<Char, Int>()

        for (char in s) {
            map[char] = map.getOrDefault(char, 0) + 1
        }

        for (i in s.indices) {
            if (map[s[i]] == 1) {
                return i
            }
        }

        return -1
    }
}

// Array
class Solution2 {
    fun firstUniqChar(s: String): Int {
        val charCounts = IntArray(26)

        for (char in s) {
            charCounts[char - 'a']++
        }

        for (i in s.indices) {
            if (charCounts[s[i] - 'a'] == 1) {
                return i
            }
        }

        return -1
    }
}