import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Boj1707 {
    private static final ArrayList<Integer>[] graph = new ArrayList[20001];
    private static boolean[] colors = new boolean[20001];
    private static boolean[] colored = new boolean[20001];
    private static int v, e;

    private static boolean bfs(int node) {
        if (colored[node])
            return true;
        ArrayList<Integer> q = new ArrayList<>();
        q.add(node);
        colored[node] = true;

        while (q.size() > 0) {
            ArrayList<Integer> next = new ArrayList<>();
            for (int i = 0; i < q.size(); i++) {
                int current = q.get(i);
                Iterator<Integer> itr = graph[current].iterator();
                while (itr.hasNext()) {
                    int adj = itr.next();
                    if (colored[adj]) {
                        if (colors[adj] == colors[current])
                            return false;
                        continue;
                    }
                    colored[adj] = true;
                    colors[adj] = !colors[current];
                    next.add(adj);
                }
            }
            q = next;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for (int test_case = 0; test_case < TC; test_case++) {
            String[] tokens = br.readLine().split(" ");

            v = Integer.parseInt(tokens[0]);
            e = Integer.parseInt(tokens[1]);

            for (int i = 1; i <= v; i++) {
                colored[i] = false;
                graph[i].clear();
            }

            for (int i = 0; i < e; i++) {
                tokens = br.readLine().split(" ");
                int x = Integer.parseInt(tokens[0]);
                int y = Integer.parseInt(tokens[1]);
                graph[x].add(y);
                graph[y].add(x);
            }

            boolean result = true;
            for (int i = 1; i <= v && result; i++)
                result = bfs(i);

            System.out.println(result ? "YES" : "NO");
        }
    }
}
