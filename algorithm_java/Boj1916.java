import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class City implements Comparable<City> {
    int city, dist;

    public City(int city, int dist) {
        this.city = city;
        this.dist = dist;
    }

    public int compareTo(City city) {
        return this.dist > city.dist ? 1 : -1;
    }
}

public class Boj1916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());
        int[][] graph = new int[cityNum + 1][cityNum + 1];
        String[] tokens;

        for (int[] r : graph)
            Arrays.fill(r, -1);

        for (int i = 0; i < busNum; i++) {
            tokens = br.readLine().split(" ");
            int src = Integer.parseInt(tokens[0]);
            int dst = Integer.parseInt(tokens[1]);
            int time = Integer.parseInt(tokens[2]);
            graph[src][dst] = graph[src][dst] < 0 ? time : Math.min(graph[src][dst], time);
        }

        tokens = br.readLine().split(" ");
        int targetSrc = Integer.parseInt(tokens[0]);
        int targetDst = Integer.parseInt(tokens[1]);
        int[] minCost = new int[cityNum + 1];
        PriorityQueue<City> pq = new PriorityQueue<>();

        pq.add(new City(targetSrc, 0));
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[targetSrc] = 0;

        while (pq.size() > 0) {
            City city = pq.poll();
            int src = city.city;
            if (minCost[src] < city.dist) // old
                continue;
            for (int dst = 1; dst <= cityNum; dst++) {
                int time = graph[src][dst];
                if (time < 0)
                    continue;
                if (minCost[dst] > time + minCost[src]) {
                    minCost[dst] = time + minCost[src];
                    pq.add(new City(dst, minCost[dst]));
                }
            }
        }
        System.out.println(minCost[targetDst]);
    }
}
