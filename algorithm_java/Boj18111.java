import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), b = Integer.parseInt(tokens[2]);
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                map[i][j] = Integer.parseInt(tokens[j]);
        }

        System.out.println();
    }
}
