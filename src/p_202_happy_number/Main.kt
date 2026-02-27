package p_202_happy_number

// Problem link : https://leetcode.com/problems/happy-number

fun main() {
    val solution = Solution()
    println(solution.isHappy(19))
    println(solution.isHappy(2))
}

class Solution {
    fun isHappy(n: Int): Boolean {
        val seenNumbers = hashSetOf<Int>()
        var currentNumber = n

        while (currentNumber != 1 && !seenNumbers.contains(currentNumber)) {
            seenNumbers.add(currentNumber)

            var sum = 0
            var temp = currentNumber

            while (temp > 0) {
                val digit = temp % 10
                sum += digit * digit
                temp /= 10
            }

            currentNumber = sum
        }

        return currentNumber == 1
    }
}