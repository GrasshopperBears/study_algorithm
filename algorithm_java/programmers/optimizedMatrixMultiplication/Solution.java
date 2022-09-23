package programmers.optimizedMatrixMultiplication;

import java.util.Arrays;

class Solution {
    public static int solution(int[][] matrix_sizes) {
        int matrixNum = matrix_sizes.length;
        int[][] dp = new int[matrixNum][matrixNum];
        for (int[] r : dp)
            Arrays.fill(r, Integer.MAX_VALUE);
        for (int i = 0; i < matrixNum; i++)
            dp[i][i] = 0;

        for (int size = 1; size < matrixNum; size++) {
            for (int from = 0; from < matrixNum - size; from++) {
                int to = from + size;
                for (int mid = from; mid < to; mid++) {
                    dp[from][to] = Math.min(dp[from][to],
                            dp[from][mid]
                                    + matrix_sizes[from][0] * matrix_sizes[mid][1] * matrix_sizes[to][1]
                                    + dp[mid + 1][to]);
                }
            }
        }
        return dp[0][matrixNum - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][] { { 5, 3 }, { 3, 10 }, { 10, 6 } }));
    }
}
