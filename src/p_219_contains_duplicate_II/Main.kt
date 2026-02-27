package p_219_contains_duplicate_II

// Problem link : https://leetcode.com/problems/contains-duplicate-ii/

fun main() {
    val solution = Solution()
    println(solution.containsNearbyDuplicate(intArrayOf(1,2,3,1),3))
    println(solution.containsNearbyDuplicate(intArrayOf(1,0,1,1),1))
    println(solution.containsNearbyDuplicate(intArrayOf(1,2,3,1,2,3),2))
}

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val seenNumbers = hashMapOf<Int, Int>()
        nums.forEachIndexed { currentIndex, i ->
            if (!seenNumbers.contains(i)) {
                seenNumbers[i]=(currentIndex)
            } else {
                val theLastSeen = seenNumbers[i]!!
                if (currentIndex - theLastSeen <= k)
                    return true
                seenNumbers[i]=currentIndex
            }
        }
        return false
    }
}