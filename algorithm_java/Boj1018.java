import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1018 {
    private static int n, m;
    private static String[] board;

    public static int minimumChange(int row, int col) {
        int blackFirst = 0, whiteFirst = 0;
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                int pos = (i + j - row - col) % 2;
                if (board[i].charAt(j) == 'W' && pos == 0) {
                    blackFirst++;
                } else if (board[i].charAt(j) == 'B' && pos == 1) {
                    blackFirst++;
                } else if (board[i].charAt(j) == 'B' && pos == 0) {
                    whiteFirst++;
                } else if (board[i].charAt(j) == 'W' && pos == 1) {
                    whiteFirst++;
                }
            }
        }
        return Math.min(blackFirst, whiteFirst);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);
        board = new String[n];
        int min = 3000;

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().trim();
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                min = Math.min(min, minimumChange(i, j));
            }
        }

        System.out.println(min);
    }
}
