import java.util.*;

class Solution {
    private static int[][] g;
    private static int n;
    private static HashMap<Integer, List<List<Integer>>> dp = new HashMap<>();

    private static List<List<Integer>> dfs(int node) {
        if (dp.containsKey(node)) new ArrayList<>(dp.get(node));

        ArrayList<List<Integer>> answer = new ArrayList<>();
        if (node == n-1) answer.add(new ArrayList<>(List.of(node)));
        if (g[node].length > 0) {
            for (int adj: g[node]) {
                List<List<Integer>> subResult = dfs(adj);
                for (List<Integer> el: subResult) el.add(node);
                answer.addAll(subResult);
            }
        }
        dp.put(node, new ArrayList<>(answer));
        return answer;
    }

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = graph.length;
        List<List<Integer>> answer = dfs(0);
        for (List<Integer> el: answer) Collections.reverse(el);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(allPathsSourceTarget(new int[][] {{1,2}, {3}, {3}, {}})); // [[0,1,3],[0,2,3]]
        System.out.println(allPathsSourceTarget(new int[][] {{4,3,1}, {3,2,4}, {3}, {4}, {}})); // [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
        System.out.println(allPathsSourceTarget(new int[][] {{4, 3, 1}, {3, 2, 4}, {}, {4}, {}})); // [[0,4],[0,3,4],[0,1,3,4],[0,1,4]]
        System.out.println(allPathsSourceTarget(new int[][] {{2}, {}, {1}})); // [[0,2]]
    }
}
