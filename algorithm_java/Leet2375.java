import java.util.*;

public class Leet2375 {
    private static String s;
    private static Stack<Integer> stack = new Stack<>();
    private static boolean[] used = new boolean[10];

    private static boolean dfs(int idx, int prev, boolean isIncrease) {
        int min = isIncrease ? prev + 1 : 1, max = isIncrease ? 10 : prev;
        for (int i = min; i < max; i++) {
            if (used[i])
                continue;
            used[i] = true;
            stack.push(i);
            if (idx == s.length())
                return true;
            if (dfs(idx + 1, i, s.charAt(idx) == 'I'))
                return true;
            stack.pop();
            used[i] = false;
        }

        return false;
    }

    public static String smallestNumber(String pattern) {
        StringBuilder answer = new StringBuilder();
        s = pattern;
        dfs(0, 0, true);
        while (stack.size() > 0)
            answer.append(stack.pop());
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        // System.out.println(smallestNumber("IIIDIDDD")); // 123549876
        System.out.println(smallestNumber("DDD")); // 4321
    }
}
