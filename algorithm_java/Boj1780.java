import java.io.BufferedReader;
import java.io.InputStreamReader;

class PaperCount {
    int minus = 0, zero = 0, plus = 0;

    public void set(int num) {
        if (num > 0)
            plus++;
        else if (num == 0)
            zero++;
        else
            minus++;
    }
}

public class Boj1780 {
    private static int n;
    private static int[][] map;

    private static PaperCount count(int r, int c, int size) {
        int base = map[r][c];
        PaperCount result = new PaperCount();

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (map[i][j] != base) {
                    int nextSize = size / 3;
                    PaperCount[] results = new PaperCount[] {
                            count(r, c, nextSize),
                            count(r, c + nextSize, nextSize),
                            count(r, c + 2 * nextSize, nextSize),
                            count(r + nextSize, c, nextSize),
                            count(r + nextSize, c + nextSize, nextSize),
                            count(r + nextSize, c + 2 * nextSize, nextSize),
                            count(r + 2 * nextSize, c, nextSize),
                            count(r + 2 * nextSize, c + nextSize, nextSize),
                            count(r + 2 * nextSize, c + 2 * nextSize, nextSize),
                    };
                    for (PaperCount subResult : results) {
                        result.minus += subResult.minus;
                        result.zero += subResult.zero;
                        result.plus += subResult.plus;
                    }
                    return result;
                }
            }
        }
        result.set(base);
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(tokens[j]);
        }
        PaperCount result = count(0, 0, n);
        System.out.printf("%d\n%d\n%d", result.minus, result.zero, result.plus);
    }
}
