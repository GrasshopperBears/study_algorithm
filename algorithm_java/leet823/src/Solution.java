import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int numFactoredBinaryTrees(int[] arr) {
        long[] dp = new long[arr.length];
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        HashMap<Integer, Integer> indices = new HashMap<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int bound = (int)Math.round(Math.sqrt(num));
            indices.put(arr[i], i);
            dp[i] = 1;
            for (int factor = 2; factor <= bound; factor++) {
                if (num % factor > 0) continue;
                int div = num / factor;
                if (set.contains(factor) && set.contains(div)) {
                    long childPossible = dp[indices.get(factor)] * dp[indices.get(div)];
                    if (div != factor) childPossible *= 2;
                    dp[i] += childPossible;
                }
            }
        }
        return (int)(Arrays.stream(dp).sum() % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[] {2, 4})); // 3
        System.out.println(numFactoredBinaryTrees(new int[] {2, 4, 5, 10})); // 7
    }
}