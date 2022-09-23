package programmers.buyCookie;

import java.util.HashSet;

class Solution {
    public int solution(int[] cookie) {
        int cookieNum = cookie.length, maxCookies = 0;
        int[] prefixSum = new int[cookieNum + 1];
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < cookieNum; i++) {
            prefixSum[i + 1] = prefixSum[i] + cookie[i];
            set.add(prefixSum[i + 1]);
        }

        for (int i = 1; i < cookieNum; i++) {
            for (int j = i + 1; j <= cookieNum; j++) {
                int cookies = prefixSum[j] - prefixSum[i - 1];
                int cookiePerChild = cookies / 2;
                if (cookiePerChild << 1 != cookies || cookiePerChild <= maxCookies)
                    continue;
                if (set.contains(prefixSum[i - 1] + cookiePerChild))
                    maxCookies = Math.max(maxCookies, cookiePerChild);
            }
        }
        return maxCookies;
    }
}
