package programmers.camping;

import java.util.Arrays;

public class Solution {
    public static int solution(int n, int[][] data) {
        int answer = 0;
        Arrays.sort(data, (a, b) -> a[0] > b[0] ? 1 : -1);

        for (int i = 0; i < n - 1; i++) {
            int baseX = data[i][0], baseY = data[i][1];
            int prevMaxY = Integer.MAX_VALUE, prevMinY = 0;
            int prevX = data[i + 1][0], cachedMaxY = prevMaxY, cachedMinY = prevMinY;

            for (int j = i + 1; j < n; j++) {
                int currX = data[j][0], currY = data[j][1];
                if (baseX == currX)
                    continue;
                if (currX != prevX) {
                    cachedMaxY = prevMaxY;
                    cachedMinY = prevMinY;
                    prevX = currX;
                }
                if (currY > baseY && currY <= cachedMaxY) {
                    answer++;
                    prevMaxY = Math.min(prevMaxY, currY);
                } else if (currY < baseY && currY >= cachedMinY) {
                    answer++;
                    prevMinY = Math.max(prevMinY, currY);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int[][] { { 2, 0 }, { 0, 0 }, { 1, 1 }, { 0, 2 } })); // 3
    }
}
