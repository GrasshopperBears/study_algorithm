package programmers.moveGoldSilver;

class Solution {
    private static int[] golds, silvers, weights, times;

    private static long getMaxTime() {
        long maxTime = 0;

        for (int i = 0; i < weights.length; i++) {
            long currTime = golds[i] / weights[i] + silvers[i] / weights[i];
            if (golds[i] % weights[i] > 0)
                currTime++;
            if (silvers[i] % weights[i] > 0)
                currTime++;
            maxTime = Math.max(maxTime, currTime * 2 * times[i]);
        }
        return maxTime;
    }

    private static boolean isPossible(long time, int city, int gold, int silver) {
        if (city == golds.length)
            return gold <= 0 && silver <= 0;
        if (gold <= 0 && silver <= 0)
            return true;
        long maxTrip = (time / times[city] + 1) / 2, maxMove = weights[city] * maxTrip;
        int maxGold = Math.min(gold, (int) Math.min(golds[city], maxMove));

        for (int goldMove = 0; goldMove <= maxGold; goldMove++) {
            int silverMove = Math.min(silver,
                    (int) Math.min(silvers[city], maxMove > goldMove ? maxMove - goldMove : 0));
            if (isPossible(time, city + 1, gold - goldMove, silver - silverMove))
                return true;
        }
        return false;
    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        golds = g;
        silvers = s;
        weights = w;
        times = t;
        long left = 1, right = getMaxTime();

        while (left < right) {
            long mid = (left + right) / 2;
            if (isPossible(mid, 0, a, b))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[] { 100 }, new int[] { 100 }, new int[] { 7 }, new int[] { 10 }));
        System.out.println(solution(90, 500,
                new int[] { 70, 70, 0 }, new int[] { 0, 0, 500 }, new int[] { 100, 100, 2 }, new int[] { 4, 8, 1 }));
    }
}
