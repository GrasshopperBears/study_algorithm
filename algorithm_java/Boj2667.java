import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class PP {
    int r, c;

    public PP(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Boj2667 {
    private static final int[] directions = new int[] { 0, -1, 0, 1, 0 };
    private static boolean[][] visited;
    private static char[][] apt;
    private static int n;

    private static int bfs(int r, int c) {
        if (apt[r][c] == '0' || visited[r][c])
            return 0;

        int count = 0, base = apt[r][c];
        Queue<PP> q = new LinkedList<>();
        q.add(new PP(r, c));
        visited[r][c] = true;

        while (q.size() > 0) {
            PP point = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nextR = point.r + directions[i];
                int nextC = point.c + directions[i + 1];
                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n)
                    continue;
                if (!visited[nextR][nextC] && apt[nextR][nextC] == base) {
                    visited[nextR][nextC] = true;
                    q.add(new PP(nextR, nextC));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        apt = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++)
                apt[i][j] = line.charAt(j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = bfs(i, j);
                if (num > 0)
                    nums.add(num);
            }
        }
        Collections.sort(nums);

        answer.append(nums.size()).append('\n');
        for (int i = 0; i < nums.size(); i++)
            answer.append(nums.get(i)).append('\n');

        System.out.println(answer.toString());
    }
}
