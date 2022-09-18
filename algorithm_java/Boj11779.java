import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class City11779 implements Comparable<City11779> {
    int city, dist;
    City11779 past;

    public City11779(int city, int dist, City11779 past) {
        this.city = city;
        this.dist = dist;
        this.past = past;
    }

    public ArrayList<Integer> getPath() {
        ArrayList<Integer> path = new ArrayList<>();
        City11779 curr = this;
        while (curr != null) {
            path.add(curr.city);
            curr = curr.past;
        }
        return path;
    }

    public int compareTo(City11779 city) {
        return this.dist - city.dist;
    }
}

public class Boj11779 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        int[] minDist = new int[n + 1];
        String[] tokens;
        PriorityQueue<City11779> nextMin = new PriorityQueue<>();
        City11779 result = null;

        Arrays.fill(minDist, Integer.MAX_VALUE);
        for (int[] r : graph)
            Arrays.fill(r, -1);

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]), to = Integer.parseInt(tokens[1]), cost = Integer.parseInt(tokens[2]);
            if (graph[from][to] < 0 || graph[from][to] > cost)
                graph[from][to] = cost;
        }
        tokens = br.readLine().split(" ");
        int from = Integer.parseInt(tokens[0]), to = Integer.parseInt(tokens[1]);
        minDist[from] = 0;
        nextMin.add(new City11779(from, 0, null));

        while (nextMin.size() > 0) {
            City11779 closest = nextMin.poll();
            if (closest.dist != minDist[closest.city])
                continue;
            if (closest.city == to) {
                if (result == null || result.dist < closest.dist)
                    result = closest;
                continue;
            }
            for (int adj = 1; adj <= n; adj++) {
                int cost = graph[closest.city][adj];
                if (cost >= 0 && closest.dist + cost < minDist[adj]) {
                    nextMin.add(new City11779(adj, closest.dist + cost, closest));
                    minDist[adj] = closest.dist + cost;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> path = result.getPath();
        answer.append(minDist[to]).append('\n').append(path.size()).append('\n');
        for (int i = path.size() - 1; i >= 0; i--)
            answer.append(path.get(i)).append(' ');
        System.out.println(answer.toString());
    }
}
