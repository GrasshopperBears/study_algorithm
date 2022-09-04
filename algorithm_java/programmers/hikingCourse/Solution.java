package programmers.hikingCourse;

import java.util.*;

class Path implements Comparable<Path> {
    int p1, p2, cost;

    public Path(int p1, int p2, int cost) {
        this.p1 = p1;
        this.p2 = p2;
        this.cost = cost;
    }

    public int compareTo(Path path) {
        return this.cost - path.cost;
    }
}

class Solution {
    private static boolean[] visited;
    private static ArrayList<Integer>[] graph;
    private static HashSet<Integer> summitSet = new HashSet<>(), gateSet = new HashSet<>();

    private static int findGate(int summit) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(visited, false);
        q.add(summit);
        visited[summit] = true;

        while (q.size() > 0) {
            int pos = q.poll();
            if (gateSet.contains(pos))
                return pos;
            if (summitSet.contains(pos) && pos != summit)
                continue;
            ArrayList<Integer> adjList = graph[pos];
            if (adjList == null)
                continue;
            for (int adj : adjList) {
                if (!visited[adj]) {
                    q.add(adj);
                    visited[adj] = true;
                }
            }
        }
        return 0;
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        int[] answer = new int[2];

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int summit : summits)
            summitSet.add(summit);
        for (int gate : gates)
            gateSet.add(gate);

        for (int[] path : paths)
            pq.add(new Path(path[0], path[1], path[2]));

        while (pq.size() > 0) {
            int minPathCost = pq.peek().cost;
            while (pq.size() > 0 && pq.peek().cost == minPathCost) {
                Path minPath = pq.poll();
                if (graph[minPath.p1] == null)
                    graph[minPath.p1] = new ArrayList<>();
                if (graph[minPath.p2] == null)
                    graph[minPath.p2] = new ArrayList<>();
                graph[minPath.p1].add(minPath.p2);
                graph[minPath.p2].add(minPath.p1);
            }
            for (int summit : summitSet) {
                int gate = findGate(summit);
                if (gate > 0) {
                    answer[0] = summit;
                    answer[1] = minPathCost;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // System.out.println(solution(6, new int[][] { { 1, 2, 3 }, { 2, 3, 5 }, { 2,
        // 4, 2 }, { 2, 5, 4 }, { 3, 4, 4 },
        // { 4, 5, 3 }, { 4, 6, 1 }, { 5, 6, 1 } }, new int[] { 1, 3 },
        // new int[] { 5
        // }));
        System.out.println(solution(7,
                new int[][] { { 1, 4, 4 }, { 1, 6, 1 }, { 1, 7, 3 }, { 2, 5, 2 }, { 3, 7, 4
                }, { 5, 6, 6 } },
                new int[] { 1 }, new int[] { 2, 3, 4 }));
        // System.out.println(solution(7, new int[][] { { 1, 2, 5 }, { 1, 4, 1 }, { 2,
        // 3, 1 }, { 2, 6, 7 }, { 4, 5, 1 },
        // { 5, 6, 1 }, { 6, 7, 1 } }, new int[] { 3, 7 }, new int[] { 1, 5 }));
        System.out.println(solution(5,
                new int[][] { { 1, 3, 10 }, { 1, 4, 20 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3, 5,
                        20 }, { 4, 5, 6 } },
                new int[] { 1, 2 }, new int[] { 5 }));
    }
}
