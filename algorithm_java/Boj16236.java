import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class PPP implements Comparable<PPP> {
    int r, c;

    public PPP(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int compareTo(PPP point) {
        if (this.r != point.r)
            return this.r - point.r;
        return this.c - point.c;
    }
}

public class Boj16236 {
    private static int n, sharkSize = 2, time = 0, eaten = 0;
    private static boolean[][] visited;
    private static int[][] map;
    private static final int[][] directions = new int[][] { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    private static PPP shark;

    private static void findPos(ArrayList<PPP> cands, int currTime) {
        Collections.sort(cands);
        shark = cands.get(0);
        map[shark.r][shark.c] = 0;
        time += currTime;
        eaten++;
        if (eaten == sharkSize) {
            sharkSize++;
            eaten = 0;
        }
    }

    private static void bfs() {
        for (boolean[] r : visited)
            Arrays.fill(r, false);
        int currTime = 1;
        Queue<PPP> q = new LinkedList<>();
        ArrayList<PPP> cands = new ArrayList<>();
        visited[shark.r][shark.c] = true;
        q.add(shark);
        q.add(null);

        while (q.size() > 0) {
            PPP current = q.poll();
            if (current == null) {
                if (cands.size() > 0) {
                    findPos(cands, currTime);
                    return;
                }
                if (q.size() == 0)
                    break;
                q.add(null);
                currTime++;
                continue;
            }
            for (int[] direction : directions) {
                int nextR = current.r + direction[0], nextC = current.c + direction[1];
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n)
                    continue;
                if (visited[nextR][nextC])
                    continue;

                int nextVal = map[nextR][nextC];
                if (nextVal > sharkSize)
                    continue;
                if (nextVal > 0 && nextVal < sharkSize) {
                    cands.add(new PPP(nextR, nextC));
                    continue;
                }
                visited[nextR][nextC] = true;
                q.add(new PPP(nextR, nextC));
            }
        }
        shark = null;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(tokens[j]);
                map[i][j] = num;
                if (num == 9) {
                    shark = new PPP(i, j);
                    map[i][j] = 0;
                }
            }
        }

        while (shark != null)
            bfs();

        System.out.println(time);
    }
}
