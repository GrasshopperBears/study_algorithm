import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static int numFactoredBinaryTrees(int[] arr) {
        long answer = 0;
        Set<Integer> set = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        HashMap<Integer, Long> dp = new HashMap<>();
        Arrays.sort(arr);

        for (int num : arr) {
            int bound = (int) Math.round(Math.sqrt(num));
            dp.put(num, (long) 1);
            for (int factor = 2; factor <= bound; factor++) {
                if (num % factor > 0) continue;
                int div = num / factor;
                if (set.contains(factor) && set.contains(div)) {
                    long childPossible = dp.get(factor) * dp.get(div);
                    if (div != factor) childPossible *= 2;
                    dp.put(num, dp.get(num) + childPossible);
                }
            }
            answer = (answer + dp.get(num)) % 1000000007;
        }
        return (int)answer;
    }

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[] {2, 4})); // 3
        System.out.println(numFactoredBinaryTrees(new int[] {2, 4, 5, 10})); // 7
    }
}