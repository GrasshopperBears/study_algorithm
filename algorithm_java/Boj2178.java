import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2178 {
    private static final int[] directions = new int[] { 0, -1, 0, 1, 0 };
    private static boolean[][] visited, graph;
    private static int n, m;

    private static int bfs() {
        int count = 0;
        Queue<PP> q = new LinkedList<>();
        q.add(new PP(0, 0));
        q.add(null);
        visited[0][0] = true;

        while (q.size() > 0) {
            PP point = q.poll();

            if (point == null) {
                count++;
                q.add(null);
                continue;
            }
            if (point.r == n - 1 && point.c == m - 1)
                break;

            for (int i = 0; i < 4; i++) {
                int nextR = point.r + directions[i];
                int nextC = point.c + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m)
                    continue;
                if (!visited[nextR][nextC] && graph[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.add(new PP(nextR, nextC));
                }
            }
        }
        return count + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        visited = new boolean[n][m];
        graph = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++)
                graph[i][j] = line.charAt(j) == '1';
        }
        System.out.println(bfs());
    }
}
