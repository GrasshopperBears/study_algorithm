import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BfsNode {
    int r, c;

    public BfsNode(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Boj10026 {
    private static final int[] directions = new int[] { 0, -1, 0, 1, 0 };
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;

    private static void bfs(int r, int c, boolean isWeakness) {
        Queue<BfsNode> q = new LinkedList<>();
        int base = map[r][c];
        q.add(new BfsNode(r, c));
        visited[r][c] = true;
        while (q.size() > 0) {
            BfsNode first = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = first.r + directions[i];
                int nextC = first.c + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n)
                    continue;
                if (visited[nextR][nextC])
                    continue;

                int next = map[nextR][nextC];
                if (isWeakness) {
                    if (base == 0 && next != 0)
                        continue;
                    if (base != 0 && base * next == 0)
                        continue;
                } else {
                    if (base != map[nextR][nextC])
                        continue;
                }
                q.add(new BfsNode(nextR, nextC));
                visited[nextR][nextC] = true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int normal = 0, weakness = 0;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                if (c == 'R')
                    map[i][j]++;
                else if (c == 'G')
                    map[i][j]--;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    normal++;
                    bfs(i, j, false);
                }
            }
        }
        for (boolean[] r : visited)
            Arrays.fill(r, false);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    weakness++;
                    bfs(i, j, true);
                }
            }
        }
        System.out.printf("%d %d\n", normal, weakness);
    }
}
