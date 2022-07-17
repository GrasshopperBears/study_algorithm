import java.util.*;

class Leet886 {
    private static boolean checkOddCycle(int node, List<List<Integer>> graph, int[] mark, int currentMark) {
        if (mark[node] == 0) return false;
        if (mark[node] > 0) return (currentMark - mark[node]) % 2 == 1;
        mark[node] = currentMark;
        for (int adj: graph.get(node)) {
            if (checkOddCycle(adj, graph, mark, currentMark+1)) return true;
        }
        mark[node] = 0;
        return false;
    }

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] mark = new int[n];    // -1: unchecked, 0: check finished, x(>0): timestamp to check cycle with its length
        Arrays.fill(mark, -1);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike: dislikes) {
            int p1 = dislike[0]-1, p2 = dislike[1]-1;
            graph.get(p1).add(p2);
            graph.get(p2).add(p1);
        }
        for (int i = 0; i < n; i++) {
            if (checkOddCycle(i, graph, mark, 1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(possibleBipartition(4, new int[][] {{1,2}, {1,3}, {2,4}})); // true
        System.out.println(possibleBipartition(3, new int[][] {{1,2}, {1,3}, {2,3}})); // false
        System.out.println(possibleBipartition(5, new int[][] {{1,2}, {2,3}, {3,4}, {4,5}, {1,5}})); // false
    }
}

