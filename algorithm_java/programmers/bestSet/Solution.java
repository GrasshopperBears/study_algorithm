package programmers.bestSet;

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s)
            return new int[] { -1 };

        int[] answer = new int[n];
        int base = s / n;

        Arrays.fill(answer, base);
        for (int i = n - 1; i > n + base * n - s; i++)
            answer[i]++;

        return answer;
    }
}