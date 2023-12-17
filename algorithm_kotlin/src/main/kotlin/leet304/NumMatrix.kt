package leet304

class NumMatrix(matrix: Array<IntArray>) {
    private val dp: Array<IntArray>
    private val rows: Int = matrix.size
    private val cols: Int = matrix[0].size

    init {
        dp = arrayOfNulls<IntArray>(rows + 1).map { _ -> IntArray(cols + 1) }.toTypedArray()
        for (row in 1..rows) {
            for (col in 1..cols) {
                dp[row][col] = matrix[row - 1][col - 1] + dp[row - 1][col] + dp[row][col - 1] - dp[row - 1][col - 1]
            }
        }
    }

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
        return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1]
    }
}
