import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine()), maxN = 0;
        int[] ns = new int[tc];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            int num = Integer.parseInt(br.readLine());
            ns[i] = num;
            maxN = Math.max(maxN, num);
        }

        long[] dp = new long[Math.max(maxN, 5)];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;

        for (int i = 5; i < dp.length; i++)
            dp[i] = dp[i - 1] + dp[i - 5];
        for (int i = 0; i < tc; i++)
            answer.append(dp[ns[i] - 1]).append('\n');

        System.out.println(answer.toString());
    }
}
