import java.util.LinkedList;
import java.util.Queue;

public class Leet1999 {
    private int getTenTimes(int num) {
        int tenTimes = num << 1, curr = 0;
        for (int i = 0; i < 5; i++) {
            curr += tenTimes;
            if (curr < 0)
                break;
        }
        if (curr < 0)
            return -1;
        return curr;
    }

    public int findInteger(int k, int digit1, int digit2) {
        int sm = Math.min(digit1, digit2), lg = digit1 + digit2 - sm;
        Queue<Integer> q = new LinkedList<>();
        q.add(sm);
        q.add(lg);

        while (q.size() > 0) {
            int first = q.poll();
            if (first > k && first % k == 0)
                return first;

            int tenTimes = getTenTimes(first);
            if (tenTimes < 0)
                continue;
            int nextSm = tenTimes + sm, nextLg = tenTimes + lg;

            if (nextSm > 0)
                q.add(nextSm);
            if (nextLg > 0)
                q.add(nextLg);
        }
        return -1;
    }
}
