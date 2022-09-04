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
    private static boolean[] visited, isGate, isSummit;
    private static ArrayList<Integer>[] graph, visitable;

    private static int findGate(int summit) {
        Queue<Integer> q = new LinkedList<>(visitable[summit]);
        Arrays.fill(visited, false);
        for (int i : q)
            visited[i] = true;

        while (q.size() > 0) {
            int pos = q.poll();
            if (isGate[pos])
                return pos;
            ArrayList<Integer> adjList = graph[pos];
            if (adjList == null)
                continue;
            for (int adj : adjList) {
                if (!visited[adj] && !isSummit[adj]) {
                    q.add(adj);
                    visited[adj] = true;
                    visitable[summit].add(adj);
                }
            }
        }
        return 0;
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int pathCount = paths.length;
        int[] answer = new int[2];
        ArrayList<Path> pq = new ArrayList<>(pathCount);
        int idx = 0;
        visitable = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            visitable[i] = new ArrayList<>();
            visitable[i].add(i);
        }

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        isGate = new boolean[n + 1];
        isSummit = new boolean[n + 1];

        Arrays.sort(summits);
        for (int gate : gates)
            isGate[gate] = true;
        for (int summit : summits)
            isSummit[summit] = true;

        for (int i = 0; i < pathCount; i++) {
            int[] path = paths[i];
            pq.add(new Path(path[0], path[1], path[2]));
        }
        Collections.sort(pq);

        while (idx < pathCount) {
            int minPathCost = pq.get(idx).cost;
            while (idx < pathCount && pq.get(idx).cost == minPathCost) {
                Path minPath = pq.get(idx++);
                if (graph[minPath.p1] == null)
                    graph[minPath.p1] = new ArrayList<>();
                if (graph[minPath.p2] == null)
                    graph[minPath.p2] = new ArrayList<>();
                graph[minPath.p1].add(minPath.p2);
                graph[minPath.p2].add(minPath.p1);
            }
            for (int summit : summits) {
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
