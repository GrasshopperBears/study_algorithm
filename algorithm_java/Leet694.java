import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Node694 {
    int relR, relC;

    public Node694(int relR, int relC) {
        this.relR = relR;
        this.relC = relC;
    }
}

public class Leet694 {
    private static int rows, cols;
    private static boolean[][] visited;
    private static int[] directions = new int[] { 0, -1, 0, 1, 0 };
    private static ArrayList<HashSet<Integer>> shapes = new ArrayList<>();

    private static int getHash(int relR, int relC) {
        return 2 * rows * relR + relC;
    }

    private static boolean bfs(int[][] grid, int r, int c) {
        Queue<Node694> q = new LinkedList<>();
        HashSet<Integer> shape = new HashSet<>();
        q.add(new Node694(0, 0));
        visited[r][c] = true;
        shape.add(getHash(0, 0));

        while (q.size() > 0) {
            Node694 first = q.poll();
            int currR = r + first.relR, currC = c + first.relC;
            for (int i = 0; i < 4; i++) {
                int nextR = currR + directions[i], nextC = currC + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= rows || nextC >= cols)
                    continue;
                if (visited[nextR][nextC] || grid[nextR][nextC] == 0)
                    continue;
                visited[nextR][nextC] = true;
                int nextRelR = first.relR + directions[i], nextRelC = first.relC + directions[i + 1];
                q.add(new Node694(nextRelR, nextRelC));
                shape.add(getHash(nextRelR, nextRelC));
            }
        }
        for (HashSet<Integer> s : shapes) {
            if (s.size() != shape.size())
                continue;
            if (s.equals(shape))
                return false;
        }
        shapes.add(shape);
        return true;
    }

    public static int numDistinctIslands(int[][] grid) {
        int islands = 0;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j] && bfs(grid, i, j)) {
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        System.out.println(numDistinctIslands(
                new int[][] { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 1 } })); // 1
        System.out.println(numDistinctIslands(
                new int[][] { { 1, 1, 0, 1, 1 }, { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1 } })); // 3
        System.out.println(numDistinctIslands(
                new int[][] { { 1, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 1, 1 }, { 1, 1, 0, 1 } })); // 2
    }
}
