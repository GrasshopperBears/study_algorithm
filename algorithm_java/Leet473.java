import java.util.Arrays;

public class Leet473 {
    int edgeLen;
    int[] matches;
    boolean[] used;

    private boolean dfs(int edge, int currEdgeLen) {
        if (currEdgeLen == edgeLen) {
            if (edge == 3)
                return true;
            return dfs(edge + 1, 0);
        }
        for (int i = 0; i < matches.length;) {
            int match = matches[i];
            if (currEdgeLen + match <= edgeLen && !used[i]) {
                used[i] = true;
                if (dfs(edge, currEdgeLen + match))
                    return true;
                used[i] = false;
                while (i < matches.length && matches[i] == match)
                    i++;
            }
        }
        return false;
    }

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        Arrays.sort(matchsticks);
        this.matches = matchsticks;
        this.used = new boolean[matchsticks.length];

        for (int match : matchsticks)
            sum += match;
        if (sum % 4 > 0)
            return false;
        edgeLen = sum / 4;
        return dfs(0, 0);
    }
}
