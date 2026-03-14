package p_560_subarray_sum_equals_k

// Problem link : https://leetcode.com/problems/subarray-sum-equals-k

fun main() {
    val solution = Solution()

    val nums1 = intArrayOf(1, 1, 1)
    println(solution.subarraySum(nums1, 2))

}

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var currentSum = 0

        val prefixSums = HashMap<Int, Int>()
        prefixSums[0] = 1

        for (num in nums) {
            currentSum += num
            val difference = currentSum - k

            if (prefixSums.containsKey(difference)) {
                count += prefixSums[difference]!!
            }

            prefixSums[currentSum] = prefixSums.getOrDefault(currentSum, 0) + 1
        }

        return count
    }
}