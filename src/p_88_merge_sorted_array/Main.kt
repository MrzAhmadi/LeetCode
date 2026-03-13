package p_88_merge_sorted_array

// Problem link : https://leetcode.com/problems/merge-sorted-array

fun main() {
    val solution = Solution()

    val nums1Ex1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val nums2Ex1 = intArrayOf(2, 5, 6)
    solution.merge(nums1Ex1, 3, nums2Ex1, 3)
    println(nums1Ex1.contentToString())

    val nums1Ex2 = intArrayOf(1)
    val nums2Ex2 = intArrayOf()
    solution.merge(nums1Ex2, 1, nums2Ex2, 0)
    println(nums1Ex2.contentToString())

    val nums1Ex3 = intArrayOf(0)
    val nums2Ex3 = intArrayOf(1)
    solution.merge(nums1Ex3, 0, nums2Ex3, 1)
    println(nums1Ex3.contentToString())
}

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var p1 = m - 1
        var p2 = n - 1
        var pMerge = m + n - 1

        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[pMerge] = nums1[p1]
                p1--
            } else {
                nums1[pMerge] = nums2[p2]
                p2--
            }
            pMerge--
        }
    }
}