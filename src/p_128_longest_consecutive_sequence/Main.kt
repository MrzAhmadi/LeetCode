package p_128_longest_consecutive_sequence

// Problem link : https://leetcode.com/problems/longest-consecutive-sequence

fun main() {
    val solution = Solution()
    println(solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    println(solution.longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
    println(solution.longestConsecutive(intArrayOf(1,0,1,2)))
}

class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val numSet = nums.toHashSet()
        var longestStreak = 0
        for (num in numSet) {
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }
                if (currentStreak > longestStreak)
                    longestStreak = currentStreak
            }
        }
        return longestStreak
    }
}