package programmers.gps;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Info implements Comparable<Info> {
    int modify, pos, time;

    public Info(int modify, int pos, int time) {
        this.modify = modify;
        this.pos = pos;
        this.time = time;
    }

    public int compareTo(Info info) {
        return this.modify > info.modify ? 1 : -1;
    }
}

class Solution {
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int from = gps_log[0], to = gps_log[k - 1];
        PriorityQueue<Info> pq = new PriorityQueue<>();
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int[] edge : edge_list) {
            int a = edge[0], b = edge[1];
            if (graph[a] == null)
                graph[a] = new ArrayList<>();
            if (graph[b] == null)
                graph[b] = new ArrayList<>();
            graph[a].add(b);
            graph[b].add(a);
        }

        pq.add(new Info(0, from, 0));

        while (pq.size() > 0) {
            Info info = pq.poll();
            if (info.time == k - 1) {
                if (info.pos == to)
                    return info.modify;
                continue;
            }
            if (graph[info.pos] == null)
                continue;
            for (int adj : graph[info.pos]) {
                int nextTime = info.time + 1;
                pq.add(new Info(info.modify + (gps_log[nextTime] == adj ? 0 : 1), adj, nextTime));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(7, 10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 },
                { 4, 6 }, { 5, 6 }, { 5, 7 }, { 6, 7 } }, 6, new int[] { 1, 2, 3, 3, 6, 7 }));
        System.out.println(solution(7, 10, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 },
                { 4, 6 }, { 5, 6 }, { 5, 7 }, { 6, 7 } }, 6, new int[] { 1, 2, 4, 6, 5, 7 }));
    }
}
