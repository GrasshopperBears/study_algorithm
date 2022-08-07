import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj1240 {
    private static final int LIMIT = 10001;
    private static boolean[] visited;
    private static int[][] graph;
    private static int dist, N;
    private static boolean found;

    private static void visit(int curr, int target, int currDist) {
        if (curr == target) {
            dist = currDist;
            found = true;
            return;
        }
        if (visited[curr]) return;
        visited[curr] = true;
        for (int i = 1; i <= N; i++) {
            if (graph[curr][i] < LIMIT) {
                visit(i, target, currDist + graph[curr][i]);
                if (found) {
                    visited[curr] = false;
                    return;
                }
            }
        }
        visited[curr] = false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int[] r: graph)
            Arrays.fill(r, LIMIT);

        for (int i = 0; i < N-1; i++) {
            tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            int d = Integer.parseInt(tokens[2]);
            graph[x][y] = d;
            graph[y][x] = d;
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < M; i++) {
            tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            dist = 0;
            found = false;
            visit(x, y, 0);
            answer.append(dist).append("\n");
        }
        System.out.println(answer.toString());
    }
}
