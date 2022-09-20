public class Leet289 {
    public void gameOfLife(int[][] board) {
        int rows = board.length, cols = board[0].length;
        int[][] counts = new int[rows][cols];
        int[][] directions = new int[][] {
                { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int[] direction : directions) {
                    int r = i + direction[0], c = j + direction[1];
                    if (r < 0 || c < 0 || r >= rows || c >= cols)
                        continue;
                    if (board[r][c] == 1)
                        counts[i][j]++;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int count = counts[i][j];
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3)
                        board[i][j] = 0;
                } else if (count == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
