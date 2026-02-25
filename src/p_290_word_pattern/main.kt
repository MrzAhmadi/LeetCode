package p_290_word_pattern

// Problem link : https://leetcode.com/problems/word-pattern

fun main() {
    val solution = Solution()
    println(solution.wordPattern("abba", "dog cat cat dog"))
    println(solution.wordPattern("abba", "dog cat cat fish"))
    println(solution.wordPattern("aaaa", "dog cat cat dog"))
}

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {

        val wordList = s.split(" ")

        if (pattern.length != wordList.size) return false

        val letterToWord = hashMapOf<Char, String>()
        val wordToLetter = hashMapOf<String, Char>()

        for (i in 0..<pattern.length) {
            val currentLetter = pattern[i]
            val currentWord = wordList[i]
            if (letterToWord.contains(currentLetter) && letterToWord[currentLetter] != currentWord)
                return false
            if (wordToLetter.contains(currentWord) && wordToLetter[currentWord] != currentLetter)
                return false
            letterToWord[currentLetter] = currentWord
            wordToLetter[currentWord] = currentLetter
        }

        return true
    }
}