import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1477 {
    private static int n, m;
    private static int[] intervals, maxIntervals;
    private static int[][] dp;

    private static int splittedLen(int index, int count) {
        int result = intervals[index] / count;
        if (result * count < intervals[index])
            result++;
        return result;
    }

    private static int split(int index, int leftover) {
        if (dp[index][leftover] > 0)
            return dp[index][leftover];
        if (leftover == 0) {
            dp[index][leftover] = maxIntervals[index];
            return maxIntervals[index];
        }
        if (index == n) {
            if (intervals[index] <= leftover)
                return Integer.MAX_VALUE;
            dp[index][leftover] = splittedLen(index, leftover + 1);
            return dp[index][leftover];
        }
        int minMaxDist = Integer.MAX_VALUE;
        for (int i = 0; i <= leftover; i++) {
            int currSplit = splittedLen(index, i + 1);
            int subResult = split(index + 1, leftover - i);
            minMaxDist = Math.min(minMaxDist, Math.max(currSplit, subResult));
        }
        dp[index][leftover] = minMaxDist;
        return minMaxDist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        int l = Integer.parseInt(tokens[2]);
        int[] positions = new int[n];
        intervals = new int[n + 1];
        maxIntervals = new int[n + 1];
        dp = new int[n + 1][m + 1];

        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            positions[i] = Integer.parseInt(tokens[i]);
        Arrays.sort(positions);

        if (n > 0) {
            intervals[0] = positions[0];
            for (int i = 1; i < n; i++)
                intervals[i] = positions[i] - positions[i - 1];
            intervals[n] = l - positions[n - 1];
        } else {
            intervals[0] = l;
        }

        maxIntervals[n] = intervals[n];
        for (int i = n - 1; i >= 0; i--)
            maxIntervals[i] = Math.max(maxIntervals[i + 1], intervals[i]);

        System.out.println(split(0, m));
    }
}
