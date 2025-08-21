package leet300

class Solution {
    private fun binSearch(list: List<Int>, find: Int): Int {
        var left = 0
        var right = list.size

        while (left < right) {
            val mid = (left + right) / 2
            if (list[mid] >= find) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.size == 1) return 1

        val res = mutableListOf(nums[0])

        for (i in 1 until nums.size) {
            val num = nums[i]

            if (num > res.last()) {
                res.add(num)
            } else {
                res[binSearch(res, num)] = num
            }
        }

        return res.size
    }
}
