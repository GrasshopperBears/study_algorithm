import java.io.*;

public class Boj1405 {
    private static final int MAX_ACTIONS = 14;
    private static double answer = 0;
    private static int actions;
    private static double E, W, S, N;
    private static final boolean[][] visited = new boolean[2*MAX_ACTIONS + 1][2*MAX_ACTIONS + 1];

    private static void visit(int count, int h, int v, double p) {
        if (visited[v+MAX_ACTIONS][h+MAX_ACTIONS]) {
            answer += p;
            return;
        }
        if (count == actions) return;
        visited[v+MAX_ACTIONS][h+MAX_ACTIONS] = true;
        if (E > 0) visit(count+1, h+1, v, p*E);
        if (W > 0) visit(count+1, h-1, v, p*W);
        if (N > 0) visit(count+1, h, v+1, p*N);
        if (S > 0) visit(count+1, h, v-1, p*S);
        visited[v+MAX_ACTIONS][h+MAX_ACTIONS] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        actions = Integer.parseInt(tokens[0]);
        E = Integer.parseInt(tokens[1]) / 100.0;
        W = Integer.parseInt(tokens[2]) / 100.0;
        S = Integer.parseInt(tokens[3]) / 100.0;
        N = Integer.parseInt(tokens[4]) / 100.0;

        visit(0, 0, 0, 1);

        System.out.println(1 - answer);
    }
}
