package programmers.codingTestStudy;

import java.util.Arrays;

class Solution {
    private static int[][] times;
    private static int maxAl = 0, maxCo = 0;
    private static final int MAX_RWD = 5;

    private static void fill(int fromAl, int fromCo) {
        int base = times[fromAl][fromCo];
        for (int al = fromAl; al <= maxAl; al++) {
            for (int co = fromCo; co <= maxCo; co++)
                times[al][co] = Math.min(times[al][co], base + (al - fromAl) + (co - fromCo));
        }
    }

    public static int solution(int alp, int cop, int[][] problems) {
        for (int i = 0; i < problems.length; i++) {
            maxAl = Math.max(maxAl, problems[i][0]);
            maxCo = Math.max(maxCo, problems[i][1]);
        }

        times = new int[maxAl + MAX_RWD + 1][maxCo + MAX_RWD + 1];
        for (int[] r : times)
            Arrays.fill(r, Integer.MAX_VALUE);
        times[alp][cop] = 0;
        fill(alp, cop);

        for (int i = 0; i < problems.length; i++) {
            int alp_req = problems[i][0], cop_req = problems[i][1];
            int alp_rwd = problems[i][2], cop_rwd = problems[i][3];
            int cost = problems[i][4];

            for (int al = alp_req; al <= maxAl + MAX_RWD; al++) {
                for (int co = cop_req; co <= maxCo + MAX_RWD; co++) {
                    int prevAl = al - alp_rwd, prevCo = co - cop_rwd;
                    if (prevAl >= alp && prevCo >= cop) {
                        int possibleTime = cost + times[prevAl][prevCo];
                        if (times[al][co] > possibleTime) {
                            times[al][co] = possibleTime;
                            fill(al, co);
                        }
                    }
                }
            }
        }
        int minTime = times[maxAl][maxCo];
        for (int i = maxAl; i < times.length; i++) {
            for (int j = maxCo; j < times[0].length; j++) {
                if (times[i][j] >= 0)
                    minTime = Math.min(minTime, times[i][j]);
            }
        }
        return minTime;
    }

    public static void main(String[] args) {
        solution(10, 10, new int[][] { { 10, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } });
        solution(0, 0, new int[][] { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } });
    }
}
