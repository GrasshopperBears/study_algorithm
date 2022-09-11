import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj14500 {
    private static int[][] map;
    private static final int[][] squareWidth = new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 },
            { 1, 0 }, { 1, 1 }, { 1, 2 } };
    private static final int[][] squareHeight = new int[][] { { 0, 0 }, { 1, 0 }, { 2, 0 },
            { 0, 1 }, { 1, 1 }, { 2, 1 } };

    private static int getLineSum(int r, int c, int isHeight, int isWidth) {
        int sum = 0;
        for (int i = 0; i < 4; i++)
            sum += map[r + isHeight * i][c + isWidth * i];
        return sum;
    }

    private static int getSquareMaxSum(int r, int c, boolean isHeight) {
        int maxSum = 0, base = 0;
        int[][] squares = isHeight ? squareHeight : squareWidth;

        for (int i = 0; i < squares.length; i++)
            base += map[r + squares[i][0]][c + squares[i][1]];

        for (int i = 0; i < squares.length - 1; i++) {
            int curr = base - map[r + squares[i][0]][c + squares[i][1]];
            for (int j = i + 1; j < squares.length; j++) {
                if ((i == 0 && j == 4) || (i == 1 && j == 3) || (i == 1 && j == 5) || (i == 2 && j == 4) || (i == 1 && j == 4))
                    continue;
                maxSum = Math.max(maxSum, curr - map[r + squares[j][0]][c + squares[j][1]]);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), maxSum = 0;
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(tokens[j]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j + 3 < m)
                    maxSum = Math.max(maxSum, getLineSum(i, j, 0, 1));
                if (i + 3 < n)
                    maxSum = Math.max(maxSum, getLineSum(i, j, 1, 0));
                if (i + 1 < n && j + 2 < m)
                    maxSum = Math.max(maxSum, getSquareMaxSum(i, j, false));
                if (i + 2 < n && j + 1 < m)
                    maxSum = Math.max(maxSum, getSquareMaxSum(i, j, true));
            }
        }
        System.out.println(maxSum);
    }
}
