import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node1238 {
    int node, cost;

    public Node1238(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

public class Leet1238 {
    private static int n, m, x;
    private static int[] times;
    private static ArrayList<Node1238>[] graph;

    private static int[] dijkstra(int from) {
        Queue<Node1238> q = new LinkedList<>();
        int[] times = new int[n + 1];
        Arrays.fill(times, Integer.MAX_VALUE);
        times[from] = 0;
        q.add(new Node1238(from, 0));

        while (q.size() > 0) {
            Node1238 first = q.poll();
            if (first.cost != times[first.node])
                continue;
            for (Node1238 adj : graph[first.node]) {
                int newCost = first.cost + adj.cost;
                if (times[adj.node] > newCost) {
                    times[adj.node] = newCost;
                    q.add(new Node1238(adj.node, newCost));
                }
            }
        }
        return times;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int[] timesFromX;
        int maxTime = 0;
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        x = Integer.parseInt(tokens[2]);
        times = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            graph[Integer.parseInt(tokens[0])]
                    .add(new Node1238(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])));
        }

        timesFromX = dijkstra(x);

        for (int i = 1; i <= n; i++) {
            if (i == x)
                continue;
            times[i] += dijkstra(i)[x];
            times[i] += timesFromX[i];
        }

        for (int i = 1; i <= n; i++) {
            if (i == x)
                continue;
            maxTime = Math.max(maxTime, times[i]);
        }
        System.out.println(maxTime);
    }
}
