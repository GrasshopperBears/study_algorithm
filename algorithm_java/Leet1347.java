import java.util.HashMap;

public class Leet1347 {
    public static int minSteps(String s, String t) {
        HashMap<Character, Integer> count = new HashMap<>();
        // int[] count = new int[26];
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char left = s.charAt(i), right = t.charAt(i);
            count.put(left, count.getOrDefault(left, 0)+1);
            count.put(right, count.getOrDefault(right, 0)-1);
        }
        for (Integer val: count.values()) {
            answer += Math.abs(val);
        }
        return answer / 2;
    }

    public static void main(String[] args) {
        System.out.println(minSteps("bab", "aba")); // 1
        System.out.println(minSteps("leetcode", "practice")); // 5
        System.out.println(minSteps("anagram", "mangaar")); // 0
    }
}
