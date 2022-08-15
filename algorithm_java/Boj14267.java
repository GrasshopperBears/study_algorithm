import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj14267 {
    private static boolean[] isParent;
    private static int[] counts, parents, cumSum;
    private static HashSet<Integer>[] childs;

    private static void compress(int person, HashSet<Integer> list) {
        childs[person].addAll(list);
        if (person != 1) {
            list.add(person);
            compress(parents[person], list);
        }
    }

    private static void good(int person) {
        counts[person] += cumSum[person];
        Iterator<Integer> itr = childs[person].iterator();
        while (itr.hasNext()) {
            counts[itr.next()] += cumSum[person];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]);
        counts = new int[n + 1];
        parents = new int[n + 1];
        childs = new HashSet[n + 1];
        isParent = new boolean[n + 1];
        cumSum = new int[n + 1];

        for (int i = 1; i <= n; i++)
            childs[i] = new HashSet<>();

        tokens = br.readLine().split(" ");
        for (int i = 1; i < n; i++) {
            int parent = Integer.parseInt(tokens[i]);
            parents[i + 1] = parent;
            isParent[parent] = false;
        }
        for (int i = 1; i <= n; i++) {
            if (!isParent[i])
                compress(i, new HashSet<>());
        }
        for (int i = 0; i < m; i++) {
            tokens = br.readLine().split(" ");
            int target = Integer.parseInt(tokens[0]);
            int w = Integer.parseInt(tokens[1]);
            cumSum[target] += w;
        }
        for (int i = 1; i <= n; i++)
            good(i);

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++)
            answer.append(counts[i]).append(" ");

        System.out.println(answer.toString());
    }
}
