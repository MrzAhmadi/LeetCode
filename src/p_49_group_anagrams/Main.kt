package p_49_group_anagrams

// Problem link : https://leetcode.com/problems/group-anagrams

fun main() {
    val solution = Solution()
    val strs1 = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(solution.groupAnagrams(strs1))
    val strs2 = arrayOf("")
    println(solution.groupAnagrams(strs2))
    val strs3 = arrayOf("a")
    println(solution.groupAnagrams(strs3))
}

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val groupedAnagrams = HashMap<String, ArrayList<String>>()

        for (word in strs) {
            val chars = word.toCharArray()
            chars.sort()
            val masterKey = String(chars)

            if (!groupedAnagrams.containsKey(masterKey)) {
                groupedAnagrams[masterKey] = ArrayList()
            }
            groupedAnagrams[masterKey]!!.add(word)
        }

        return ArrayList(groupedAnagrams.values)
    }
}