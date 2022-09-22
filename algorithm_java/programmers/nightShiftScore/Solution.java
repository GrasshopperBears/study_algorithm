package programmers.nightShiftScore;

import java.util.*;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        if (works.length == 1) {
            int left = Math.max(0, works[0] - n);
            return left * left;
        }

        for (int work : works)
            pq.add(-work);

        while (n > 0) {
            int largest = -pq.poll();
            if (largest == 0)
                break;
            int next = -pq.peek();
            if (next == largest) {
                n--;
                pq.add(-(largest - 1));
            } else {
                int currWork = Math.min(n, largest - next);
                pq.add(-(largest - currWork));
                n -= currWork;
            }
        }

        for (int work : pq)
            answer += work * work;

        return answer;
    }
}
