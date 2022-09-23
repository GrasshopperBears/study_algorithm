package programmers.moveGoldAndSilver;

class Solution {
    private static int totalGold, totalSilver;
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

    private static boolean isPossible(long time) {
        long currentGold = 0, currentSilver = 0, currentTotal = 0;
        for (int city = 0; city < golds.length; city++) {
            long maxTrip = (time / times[city] + 1) / 2, maxMove = weights[city] * maxTrip;

            currentGold += Math.min(golds[city], maxMove);
            currentSilver += Math.min(silvers[city], maxMove);
            currentTotal += Math.min(golds[city] + silvers[city], maxMove);
        }
        return currentGold >= totalGold
                && currentSilver >= totalSilver
                && currentTotal >= totalGold + totalSilver;
    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        totalGold = a;
        totalSilver = b;
        golds = g;
        silvers = s;
        weights = w;
        times = t;
        long left = 1, right = getMaxTime();

        while (left < right) {
            long mid = (left + right) / 2;
            if (isPossible(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }
}
