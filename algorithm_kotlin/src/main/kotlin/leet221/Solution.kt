package leet221

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        var result = 0
        val m = matrix.size
        val n = matrix[0].size
        val dp = arrayOfNulls<List<Int>>(m).map { _ -> arrayOfNulls<Int>(n).map { 0 }.toMutableList() }

        for (i in 0 until m) {
            for (j in 0 until n) {
                val isOne = matrix[i][j] == '1'

                if (isOne) {
                    if (i > 0 && j > 0) {
                        dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1]))
                    }
                    dp[i][j] += 1
                }
                result = max(result, dp[i][j])
            }
        }
        return result * result
    }
}
