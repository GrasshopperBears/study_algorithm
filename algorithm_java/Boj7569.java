import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class ThreeDPoint {
    int r, c, h;

    public ThreeDPoint(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
}

public class Boj7569 {
    private static int[][] directions = new int[][] {
            { -1, 0, 0 }, { 1, 0, 0 },
            { 0, -1, 0 }, { 0, 1, 0 },
            { 0, 0, -1 }, { 0, 0, 1 } };
    private static int m, n, h;
    private static int[][][] tomatoes;
    private static boolean[][][] visited;
    private static Queue<ThreeDPoint> q = new LinkedList<>();

    private static void bfs() {
        int dist = 1;

        while (q.size() > 0) {
            ThreeDPoint first = q.poll();
            if (first == null) {
                if (q.size() == 0)
                    return;
                dist++;
                q.add(null);
                continue;
            }
            if (tomatoes[first.h][first.r][first.c] == 0)
                tomatoes[first.h][first.r][first.c] = dist;

            for (int[] direction : directions) {
                int nextR = first.r + direction[0], nextC = first.c + direction[1], nextH = first.h + direction[2];
                if (nextR < 0 || nextC < 0 || nextH < 0 || nextR >= n || nextC >= m || nextH >= h)
                    continue;
                if (visited[nextH][nextR][nextC] || tomatoes[nextH][nextR][nextC] == -1)
                    continue;
                visited[nextH][nextR][nextC] = true;
                q.add(new ThreeDPoint(nextR, nextC, nextH));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        m = Integer.parseInt(tokens[0]);
        n = Integer.parseInt(tokens[1]);
        h = Integer.parseInt(tokens[2]);
        tomatoes = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tokens = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    int tomato = Integer.parseInt(tokens[k]);
                    tomatoes[i][j][k] = tomato;
                    if (tomato == 1) {
                        q.add(new ThreeDPoint(j, k, i));
                        visited[i][j][k] = true;
                    }
                }
            }
        }
        q.add(null);
        bfs();

        int maxDays = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    int tomato = tomatoes[i][j][k];
                    if (tomato == 0) {
                        System.out.println(-1);
                        return;
                    }
                    maxDays = Math.max(maxDays, tomato);
                }
            }
        }

        System.out.println(maxDays - 1);
    }
}
