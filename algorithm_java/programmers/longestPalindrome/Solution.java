package programmers.longestPalindrome;

class Solution {
    public int solution(String s) {
        int answer = 0, len = s.length();

        for (int i = 0; i < len; i++) {
            int currMax = 1, left = i, right = i;
            while (--left >= 0 && ++right < len && s.charAt(left) == s.charAt(right)) {
                currMax += 2;
            }
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                int doubleMax = 2;
                left = i;
                right = i + 1;
                while (--left >= 0 && ++right < len && s.charAt(left) == s.charAt(right)) {
                    doubleMax += 2;
                }
                currMax = Math.max(currMax, doubleMax);
            }
            answer = Math.max(answer, currMax);
        }

        return answer;
    }
}
