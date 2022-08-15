import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14267 {
    private static int[] counts, cumSum;
    private static ArrayList<Integer>[] childs;

    private static void dfs(int person, int currSum) {
        int current = cumSum[person] + currSum;
        Iterator<Integer> itr = childs[person].iterator();

        counts[person] += current;
        while (itr.hasNext()) {
            int child = itr.next();
            dfs(child, current);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]);
        counts = new int[n + 1];
        childs = new ArrayList[n + 1];
        cumSum = new int[n + 1];

        for (int i = 1; i <= n; i++)
            childs[i] = new ArrayList<>();

        tokens = br.readLine().split(" ");
        for (int i = 1; i < n; i++)
            childs[Integer.parseInt(tokens[i])].add(i + 1);
        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int target = Integer.parseInt(tokens[0]);
            int w = Integer.parseInt(tokens[1]);
            cumSum[target] += w;
        }
        dfs(1, 0);

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++)
            answer.append(counts[i]).append(" ");

        System.out.println(answer.toString());
    }
}
