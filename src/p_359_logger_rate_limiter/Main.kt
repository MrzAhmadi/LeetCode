package p_359_logger_rate_limiter

// Problem link : https://leetcode.com/problems/logger-rate-limiter

fun main() {
    val logger = Logger(10)

    println(logger.shouldPrintMessage(1, "foo"))
    println(logger.shouldPrintMessage(2, "bar"))
    println(logger.shouldPrintMessage(3, "foo"))
    println(logger.shouldPrintMessage(8, "bar"))
    println(logger.shouldPrintMessage(10, "foo"))
    println(logger.shouldPrintMessage(11, "foo"))
}

class Logger(private val timeLimit: Int) {

    private val messageHistory = HashMap<String, Int>()

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        val lastSeen = messageHistory[message]

        if (lastSeen == null || timestamp - lastSeen >= timeLimit) {
            messageHistory[message] = timestamp
            return true
        }

        return false
    }
}