import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Boj11403 {
    private static int n;
    private static boolean[][] graph;
    private static boolean[] visited;
    private static HashSet<Integer> currSet = new HashSet<>();

    private static void findConnection(int node) {
        Queue<Integer> q = new LinkedList<>();
        currSet.clear();
        Arrays.fill(visited, false);

        q.add(node);

        while (q.size() > 0) {
            int curr = q.poll();
            for (int i = 0; i < n; i++) {
                if (graph[curr][i] && !visited[i]) {
                    currSet.add(i);
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        StringBuilder answer = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new boolean[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++)
                graph[i][j] = line.charAt(2 * j) == '1';
        }

        for (int i = 0; i < n; i++) {
            findConnection(i);
            for (int j = 0; j < n; j++)
                answer.append(currSet.contains(j) ? '1' : '0').append(' ');
            answer.append('\n');
        }
        System.out.println(answer.toString());
    }
}
