import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1389 {
    private static int n, m;
    private static int[][] dists;

    private static void floydWarshall() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    int newRoute = dists[j][i] + dists[i][k];
                    if (newRoute >= 0 && dists[j][k] > newRoute) {
                        dists[j][k] = newRoute;
                        dists[k][j] = newRoute;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int minDist = Integer.MAX_VALUE, minDistPerson = 1;

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        dists = new int[n + 1][n + 1];

        for (int[] r : dists)
            Arrays.fill(r, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++)
            dists[i][i] = 0;

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]);
            if (dists[a][b] != 1) {
                dists[a][b] = 1;
                dists[b][a] = 1;
            }
        }
        floydWarshall();

        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++)
                sum += dists[i][j];
            if (sum < minDist) {
                minDist = sum;
                minDistPerson = i;
            }
        }
        System.out.println(minDistPerson);
    }
}
