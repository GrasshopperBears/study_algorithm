import java.io.BufferedReader;
import java.io.InputStreamReader;

class Result {
    int blue, white;

    public Result(int blue, int white) {
        this.blue = blue;
        this.white = white;
    }
}

public class Boj2630 {
    private static boolean[][] paper;

    private static Result count(int n, int r, int c) {
        if (n == 1)
            return new Result(paper[r][c] ? 1 : 0, paper[r][c] ? 0 : 1);

        int half = n / 2;
        Result lt = count(half, r - half, c - half);
        Result rt = count(half, r - half, c);
        Result lb = count(half, r, c - half);
        Result rb = count(half, r, c);

        int whiteSum = lt.white + rt.white + lb.white + rb.white;
        int blueSum = lt.blue + rt.blue + lb.blue + rb.blue;

        if (whiteSum == 0 && lt.blue == 1 && rt.blue == 1 && lb.blue == 1 && rb.blue == 1)
            return new Result(1, 0);
        if (blueSum == 0 && lt.white == 1 && rt.white == 1 && lb.white == 1 && rb.white == 1)
            return new Result(0, 1);
        return new Result(blueSum, whiteSum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++)
                paper[i][j] = line.charAt(2 * j) == '1';
        }
        Result result = count(n, n - 1, n - 1);
        System.out.printf("%d\n%d", result.white, result.blue);
    }
}
