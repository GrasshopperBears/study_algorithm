package programmers.gps;

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        HashSet<Integer>[] graph = new HashSet[n + 1];
        int[][] dp = new int[k][n + 1];

        for (int[] edge : edge_list) {
            int a = edge[0], b = edge[1];
            if (graph[a] == null)
                graph[a] = new HashSet<>();
            if (graph[b] == null)
                graph[b] = new HashSet<>();
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int[] r : dp)
            Arrays.fill(r, -1);

        dp[0][gps_log[0]] = 0;

        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[j] == null)
                    continue;
                int minModify = -1;
                for (int adj : graph[j]) {
                    if (dp[i - 1][adj] >= 0 && (minModify < 0 || minModify > dp[i - 1][adj]))
                        minModify = dp[i - 1][adj];
                }
                if (minModify >= 0)
                    dp[i][j] = minModify + (j == gps_log[i] ? 0 : 1);
            }
        }
        return dp[k - 1][gps_log[k - 1]];
    }

    public static void main(String[] args) {
        System.out.println(solution(7, 10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 },
                { 4, 6 }, { 5, 6 }, { 5, 7 }, { 6, 7 } }, 6, new int[] { 1, 2, 3, 3, 6, 7 }));
        System.out.println(solution(7, 10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 },
                { 4, 6 }, { 5, 6 }, { 5, 7 }, { 6, 7 } }, 6, new int[] { 1, 2, 4, 6, 5, 7 }));
    }
}
