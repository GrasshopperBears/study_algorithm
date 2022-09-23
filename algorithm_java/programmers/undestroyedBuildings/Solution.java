package programmers.undestroyedBuildings;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0, rows = board.length, cols = board[0].length;
        int[][] dp = new int[rows][cols];

        for (int[] op : skill) {
            int r1 = op[1], c1 = op[2], r2 = op[3], c2 = op[4];
            int amount = op[5] * (op[0] == 2 ? 1 : -1);
            dp[r1][c1] += amount;
            if (c2 + 1 < cols)
                dp[r1][c2 + 1] -= amount;
            if (r2 + 1 < rows)
                dp[r2 + 1][c1] -= amount;
            if (c2 + 1 < cols && r2 + 1 < rows)
                dp[r2 + 1][c2 + 1] += amount;
        }
        for (int row = 1; row < rows; row++)
            for (int col = 0; col < cols; col++)
                dp[row][col] += dp[row - 1][col];
        for (int col = 1; col < cols; col++)
            for (int row = 0; row < rows; row++)
                dp[row][col] += dp[row][col - 1];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (board[i][j] + dp[i][j] > 0)
                    answer++;

        return answer;
    }
}
