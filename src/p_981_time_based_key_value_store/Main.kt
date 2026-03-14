package p_981_time_based_key_value_store

// Problem link : https://leetcode.com/problems/time-based-key-value-store

fun main() {
    val timeMap = TimeMap()

    timeMap.set("foo", "bar", 1)
    println(timeMap.get("foo", 1))
    println(timeMap.get("foo", 3))

    timeMap.set("foo", "bar2", 4)
    println(timeMap.get("foo", 4))
    println(timeMap.get("foo", 5))
}

class TimeMap() {

    private val storage = HashMap<String, ArrayList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (!storage.containsKey(key)) {
            storage[key] = ArrayList()
        }
        storage[key]!!.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val list = storage[key] ?: return ""

        var left = 0
        var right = list.size - 1
        var result = ""

        while (left <= right) {
            val mid = left + (right - left) / 2

            if (list[mid].first <= timestamp) {
                result = list[mid].second
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }
}