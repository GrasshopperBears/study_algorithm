package programmers.selectingClimbingCourse;

import java.util.*;

class Node {
    int point, intensity;

    public Node(int point, int intensity) {
        this.point = point;
        this.intensity = intensity;
    }
}

class Path {
    int point, dist;

    public Path(int point, int dist) {
        this.point = point;
        this.dist = dist;
    }
}

class Solution {
    private static int minIntensity = Integer.MAX_VALUE, summit = 0;
    private static boolean[] visited;
    private static HashSet<Integer> summitsSet = new HashSet<>(), gatesSet = new HashSet<>();
    private static ArrayList<Path>[] connections;

    private static void dfs(int point, int intensity) {
        if (summitsSet.contains(point)) {
            if (intensity < minIntensity) {
                minIntensity = intensity;
                summit = point;
            } else if (intensity == minIntensity && point < summit) {
                summit = point;
            }
            return;
        }
        if (visited[point])
            return;
        visited[point] = true;

        for (int i = 0; i < connections[point].size(); i++) {
            Path path = connections[point].get(i);
            if (!gatesSet.contains(path.point))
                dfs(path.point, Math.max(intensity, path.dist));
        }

        visited[point] = false;
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        connections = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int summit : summits)
            summitsSet.add(summit);
        for (int gate : gates)
            gatesSet.add(gate);
        for (int[] r : paths) {
            int i = r[0], j = r[1], w = r[2];
            if (connections[i] == null)
                connections[i] = new ArrayList<>();
            if (connections[j] == null)
                connections[j] = new ArrayList<>();
            connections[i].add(new Path(j, w));
            connections[j].add(new Path(i, w));
        }

        for (int gate : gates)
            dfs(gate, 0);

        return new int[] { summit, minIntensity };
    }

    public static void main(String[] args) {
        int[] ans = solution(6,
                new int[][] { { 1, 2, 3 }, { 2, 3, 5 }, { 2, 4, 2 }, { 2, 5, 4 }, { 3, 4, 4 }, { 4, 5, 3 },
                        { 4, 6, 1 }, { 5, 6, 1 } },
                new int[] { 1, 3 }, new int[] { 5 });
        System.out.printf("%d %d\n", ans[0], ans[1]); // 5, 3
    }
}
