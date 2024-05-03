package leet1272

class Solution {
    fun removeInterval(intervals: Array<IntArray>, toBeRemoved: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val rmMin = toBeRemoved[0]
        val rmMax = toBeRemoved[1]

        for (interval in intervals) {
            val left = interval[0]
            val right = interval[1]

            if (left >= rmMin && right <= rmMax) {
                continue
            } else if (right <= rmMin || left >= rmMax) {
                result.add(interval.asList())
            } else if (rmMin > left && rmMax < right) {
                result.add(listOf(left, rmMin))
                result.add(listOf(rmMax, right))
            } else if (rmMin > left) {
                result.add(listOf(left, rmMin))
            } else {
                result.add(listOf(rmMax, right))
            }
        }

        return result
    }
}
