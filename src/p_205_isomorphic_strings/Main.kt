package p_205_isomorphic_strings

// Problem link : https://leetcode.com/problems/isomorphic-strings

fun main() {
    val solution = Solution()
    println(solution.isIsomorphic("egg", "add"))
    println(solution.isIsomorphic("f11", "b23"))
    println(solution.isIsomorphic("paper", "title"))
}

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sMapT = hashMapOf<Char, Char>()
        val tMapS = hashMapOf<Char, Char>()

        for (i in 0..<s.length) {
            val currentS = s[i]
            val currentT = t[i]
            if(sMapT.contains(currentS) && sMapT[currentS]!=currentT)
                return false
            if(tMapS.contains(currentT) && tMapS[currentT]!=currentS)
                return false
            sMapT[currentS] = currentT
            tMapS[currentT] = currentS
        }

        return true
    }
}