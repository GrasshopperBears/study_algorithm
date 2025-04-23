package leet120

import kotlin.math.min

class Solution {
    private var dp = emptyList<MutableList<Int>>()

    fun minimumTotal(triangle: List<List<Int>>): Int {
        dp = triangle.map { it.map { Int.MAX_VALUE }.toMutableList() }
        dp[0][0] = triangle[0][0]

        for (i in 1 until triangle.size) {
            for (j in 0 until triangle[i].size) {
                val prevMin = if (j == 0) {
                    dp[i-1][0]
                } else if (j == triangle[i].size - 1) {
                    dp[i-1][triangle[i].size - 2]
                } else {
                    min(dp[i-1][j-1], dp[i-1][j])
                }
                dp[i][j] = prevMin + triangle[i][j]
            }
        }

        return dp.last().min()
    }
}