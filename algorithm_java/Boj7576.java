import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Grid {
    int r, c;

    public Grid(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Boj7576 {
    private static final int[] directions = new int[] { 0, -1, 0, 1, 0 };
    private static int m, n;
    private static int[][] tomatoes;
    private static Queue<Grid> q = new LinkedList<>();

    private static void bfs() {
        while (q.size() > 0) {
            Grid current = q.poll();
            int currR = current.r, currC = current.c;

            for (int i = 0; i < 4; i++) {
                int nextR = currR + directions[i];
                int nextC = currC + directions[i + 1];
                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= m)
                    continue;
                if (tomatoes[nextR][nextC] != 0)
                    continue;
                tomatoes[nextR][nextC] = tomatoes[currR][currC] + 1;
                q.add(new Grid(nextR, nextC));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");

        m = Integer.parseInt(tokens[0]);
        n = Integer.parseInt(tokens[1]);
        tomatoes = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(tokens[j]);
                tomatoes[i][j] = num;
                if (num == 1)
                    q.add(new Grid(i, j));
            }
        }

        bfs();

        int maxDate = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomatoes[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                maxDate = Math.max(maxDate, tomatoes[i][j]);
            }
        }
        System.out.println(maxDate - 1);
    }
}
