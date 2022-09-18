import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1043 {
    private static boolean[][] connected;
    private static boolean[] visited;
    private static HashSet<Integer> knowingSet = new HashSet<>();

    private static void dfs(int p) {
        if (visited[p])
            return;
        visited[p] = true;
        knowingSet.add(p);
        for (int i = 1; i < connected.length; i++) {
            if (connected[p][i])
                dfs(i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), answer = 0;
        boolean[][] parties = new boolean[m][n + 1];
        connected = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        tokens = br.readLine().split(" ");
        ArrayList<Integer> initialKnown = new ArrayList<>();

        for (int i = 1; i < tokens.length; i++)
            initialKnown.add(Integer.parseInt(tokens[i]));

        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int partyPeople = Integer.parseInt(tokens[0]);
            int prev = Integer.parseInt(tokens[1]);
            parties[i][prev] = true;
            if (partyPeople > 1) {
                for (int j = 1; j < partyPeople; j++) {
                    int next = Integer.parseInt(tokens[j + 1]);
                    parties[i][next] = true;
                    connected[prev][next] = true;
                    connected[next][prev] = true;
                    prev = next;
                }
            }
        }
        if (initialKnown.size() == 0) {
            System.out.println(m);
            return;
        }
        for (int p : initialKnown) {
            Arrays.fill(visited, false);
            dfs(p);
        }

        for (boolean[] party : parties) {
            boolean possible = true;
            for (int i = 1; i <= n; i++) {
                if (party[i] && knowingSet.contains(i)) {
                    possible = false;
                    break;
                }
            }
            if (possible)
                answer++;
        }
        System.out.println(answer);
    }
}
