import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj16928 {
    private static int[] next = new int[101];
    private static int[] posMin = new int[101];
    private static boolean[] visited = new boolean[101];

    private static void dfs(int pos, int time) {
        if (pos > 100 || visited[pos])
            return;
        if (posMin[pos] < time)
            return;
        posMin[pos] = time;
        if (pos == 100)
            return;

        visited[pos] = true;
        if (next[pos] > 0) {
            dfs(next[pos], time);
        } else {
            for (int i = 1; i <= 6; i++)
                dfs(pos + i, time + 1);
        }
        visited[pos] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]);
        for (int i = 0; i < n + m; i++) {
            tokens = br.readLine().split(" ");
            next[Integer.parseInt(tokens[0])] = Integer.parseInt(tokens[1]);
        }
        Arrays.fill(posMin, Integer.MAX_VALUE);
        dfs(1, 0);
        System.out.println(posMin[100]);
    }
}
