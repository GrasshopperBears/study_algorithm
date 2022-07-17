class Solution {
    public static int minDistance(String word1, String word2) {
        int word1Len = word1.length(), word2Len = word2.length();
        int[] prev = new int[word1Len + 1];
        for (int i = 0; i < word2Len; i++) {
            char c = word2.charAt(i);
            int[] next = new int[word1Len + 1];
            for (int j = 0; j < word1Len; j++) {
                if (word1.charAt(j) == c) {
                    next[j+1] = prev[j] + 1;
                } else {
                    next[j+1] = Math.max(next[j], prev[j+1]);
                }
            }
            prev = next;
        }
        return word1Len + word2Len - 2*prev[word1Len];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "eat")); // 2
        System.out.println(minDistance("leetcode", "etco")); // 4
    }
}
