package programmers.codingTestStudy;

import java.util.Arrays;

class Solution {
    public static int solution(int alp, int cop, int[][] problems) {
        int maxAl = 0, maxCo = 0;
        for (int i = 0; i < problems.length; i++) {
            maxAl = Math.max(maxAl, problems[i][0]);
            maxCo = Math.max(maxCo, problems[i][1]);
        }

        int[][] times = new int[maxAl + 1][maxCo + 1];
        for (int[] r : times)
            Arrays.fill(r, Integer.MAX_VALUE);

        alp = Math.min(alp, maxAl);
        cop = Math.min(cop, maxCo);
        times[alp][cop] = 0;

        for (int al = alp; al <= maxAl; al++) {
            for (int co = cop; co <= maxCo; co++) {
                if (al < maxAl)
                    times[al + 1][co] = Math.min(times[al + 1][co], times[al][co] + 1);
                if (co < maxCo)
                    times[al][co + 1] = Math.min(times[al][co + 1], times[al][co] + 1);

                for (int i = 0; i < problems.length; i++) {
                    int alp_req = problems[i][0], cop_req = problems[i][1];
                    int alp_rwd = problems[i][2], cop_rwd = problems[i][3];
                    int cost = problems[i][4];
                    int nextAl = Math.min(maxAl, al + alp_rwd), nextCo = Math.min(maxCo, co + cop_rwd);

                    if (al < alp_req || co < cop_req)
                        continue;
                    times[nextAl][nextCo] = Math.min(times[nextAl][nextCo], times[al][co] + cost);
                }
            }
        }
        return times[maxAl][maxCo];
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[][] { { 10, 15, 2, 1, 2 }, { 20, 20, 3, 3, 4 } }));
        System.out.println(solution(0, 0,
                new int[][] { { 0, 0, 2, 1, 2 }, { 4, 5, 3, 1, 2 }, { 4, 11, 4, 0, 2 }, { 10, 4, 0, 4, 2 } }));
    }
}
