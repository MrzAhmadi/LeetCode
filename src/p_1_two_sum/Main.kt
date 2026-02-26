package p_1_two_sum

// Problem link : https://leetcode.com/problems/two-sum

fun main() {
    val solution = Solution()
    println(solution.twoSum(intArrayOf(2,7,11,15),9).contentToString())
    println(solution.twoSum(intArrayOf(3,2,4),6).contentToString())
    println(solution.twoSum(intArrayOf(3,3),6).contentToString())

}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (target == 0 || nums.size < 2)
            return intArrayOf()
        if (nums.size == 2)
            return intArrayOf(0,1)

        val numMap = HashMap<Int, Int>()

        for (i in nums.indices) {
            val currentNumber = nums[i]
            val complement = target - currentNumber
            if (numMap.containsKey(complement)) {
                return intArrayOf(numMap[complement]!!, i)
            }
            numMap[currentNumber] = i
        }

        return intArrayOf()
    }
}