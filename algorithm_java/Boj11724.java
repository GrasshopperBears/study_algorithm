import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11724 {
    private static int n;
    private static boolean[] visited;
    private static boolean[][] graph;

    private static void dfs(int node) {
        if (visited[node])
            return;
        visited[node] = true;
        for (int i = 1; i <= n; i++)
            if (graph[node][i])
                dfs(i);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int m = Integer.parseInt(tokens[1]), components = 0;

        n = Integer.parseInt(tokens[0]);
        graph = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);
            graph[u][v] = true;
            graph[v][u] = true;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i);
            }
        }

        System.out.println(components);
    }
}
