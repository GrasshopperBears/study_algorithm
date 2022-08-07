import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1351 {
    private static final int MAX_SIZE = 10000000;
    private static final long[] dp = new long[MAX_SIZE + 1];
    private static long n;
    private static int maxRight, p, q;

    private static long getValue(long x) {
        if (x <= MAX_SIZE)
            return dp[(int) x];
        return getValue(x / p) + getValue(x / q);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Long.parseLong(tokens[0]);
        p = Integer.parseInt(tokens[1]);
        q = Integer.parseInt(tokens[2]);
        maxRight = (int) Math.min(MAX_SIZE, n);

        dp[0] = 1;
        for (int i = 1; i <= maxRight; i++)
            dp[i] = dp[i / p] + dp[i / q];

        System.out.println(getValue(n));
    }
}
