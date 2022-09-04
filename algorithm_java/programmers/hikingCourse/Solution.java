package programmers.hikingCourse;

import java.util.Arrays;
import java.util.PriorityQueue;

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
    private static int[] parents, heights;

    private static int findParent(int p) {
        if (parents[p] == p)
            return p;
        parents[p] = findParent(parents[p]);
        return parents[p];
    }

    private static void union(int p1, int p2) {
        p1 = findParent(p1);
        p2 = findParent(p2);
        if (p1 == p2)
            return;
        if (heights[p1] < heights[p2]) {
            parents[p1] = p2;
        } else {
            parents[p2] = p1;
            if (heights[p1] == heights[p2])
                heights[p1]++;
        }
    }

    public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        PriorityQueue<Path> pq = new PriorityQueue<>();
        int[] answer = new int[2];

        parents = new int[n + 1];
        heights = new int[n + 1];
        Arrays.sort(summits);
        for (int i = 1; i <= n; i++)
            parents[i] = i;

        for (int[] path : paths)
            pq.add(new Path(path[0], path[1], path[2]));

        while (pq.size() > 0) {
            int minPathCost = pq.peek().cost;
            while (pq.peek().cost == minPathCost) {
                Path minPath = pq.poll();
                union(minPath.p1, minPath.p2);
            }
            for (int i = 0; i < gates.length; i++) {
                for (int j = 0; j < summits.length; j++) {
                    if (findParent(gates[i]) == findParent(summits[j])) {
                        answer[0] = summits[j];
                        answer[1] = minPathCost;
                        return answer;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[][] { { 1, 2, 3 }, { 2, 3, 5 }, { 2,
                4, 2 }, { 2, 5, 4 }, { 3, 4, 4 },
                { 4, 5, 3 }, { 4, 6, 1 }, { 5, 6, 1 } }, new int[] { 1, 3 },
                new int[] { 5
                }));
        System.out.println(solution(7,
                new int[][] { { 1, 4, 4 }, { 1, 6, 1 }, { 1, 7, 3 }, { 2, 5, 2 }, { 3, 7, 4
                }, { 5, 6, 6 } },
                new int[] { 1 }, new int[] { 2, 3, 4 }));
        System.out.println(solution(7, new int[][] { { 1, 2, 5 }, { 1, 4, 1 }, { 2,
                3, 1 }, { 2, 6, 7 }, { 4, 5, 1 },
                { 5, 6, 1 }, { 6, 7, 1 } }, new int[] { 3, 7 }, new int[] { 1, 5 }));
        System.out.println(solution(5,
                new int[][] { { 1, 3, 10 }, { 1, 4, 20 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3, 5,
                        20 }, { 4, 5, 6 } },
                new int[] { 1, 2 }, new int[] { 5 }));
    }
}
