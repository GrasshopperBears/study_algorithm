public class Leet1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] connects = new int[n];
        int maxRank = 0;

        for (int[] road : roads) {
            int a = road[0], b = road[1];
            connected[a][b] = true;
            connected[b][a] = true;
            connects[a]++;
            connects[b]++;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                maxRank = Math.max(maxRank, connects[i] + connects[j] - (connected[i][j] ? 1 : 0));
            }
        }
        return maxRank;
    }
}
