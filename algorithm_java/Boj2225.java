import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2225 {
    private static int[][] dp;
    private static int n, k;

    private static int visit(int sum, int leftCount) {
        if (dp[sum][leftCount] > 0) {
            return dp[sum][leftCount];
        }
        int curr = 0;
        for (int i = 0; i <= n; i++) {
            if (sum + i <= n) {
                curr += visit(sum + i, leftCount - 1);
                curr %= 1000000000;
            }
        }
        dp[sum][leftCount] = curr;
        return curr;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);
        dp = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++)
            dp[i][1] = 1;

        System.out.println(visit(0, k));
    }
}
