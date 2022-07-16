import java.util.HashMap;

class Solution {
    public static int calculateTime(String keyboard, String word) {
        int time = 0, prevPos = 0, next;
        HashMap<Character, Integer> indices = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            indices.put(keyboard.charAt(i), i);
        }
        for (int i = 0; i < word.length(); i++) {
            next = indices.get(word.charAt(i));
            time += Math.abs(next - prevPos);
            prevPos = next;
        }
        return time;
    }

    public static void main(String[] args) {
        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba")); // 4
        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode")); // 73
    }
}
