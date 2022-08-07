package programmers.baseStationInstallation;

public class Solution {
    public static int solution(int n, int[] stations, int w) {
        int nextIndex = 0, nextPossible = stations[nextIndex] - w, currPos = 1, answer = 0;
        while (currPos <= n) {
            if (currPos < nextPossible) {
                answer++;
                currPos += (2 * w + 1);
            } else {
                currPos = stations[nextIndex] + w + 1;
                nextIndex++;
                if (nextIndex == stations.length)
                    nextPossible = n + 1;
                else
                    nextPossible = stations[nextIndex] - w;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(11, new int[] { 4, 11 }, 1)); // 3
        System.out.println(solution(16, new int[] { 9 }, 2)); // 3
    }
}
