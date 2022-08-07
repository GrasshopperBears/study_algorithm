import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2293 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().trim().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int k = Integer.parseInt(tokens[1]);
        int[] coins = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int currentCoin = coins[i];
            for (int j = currentCoin; j <= k; j++)
                dp[j] += dp[j - currentCoin];
        }
        System.out.println(dp[k]);
    }
}
