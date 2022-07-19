import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2775 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine()), k, n;
        int[] dp;
        for (int testCase = 0; testCase < testCases; testCase++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = i+1;
            }
            for (int i = 0; i < k; i++) {
                for (int j = 1; j < n; j++) dp[j] += dp[j-1];
            }
            System.out.println(dp[n-1]);
        }
    }
}
