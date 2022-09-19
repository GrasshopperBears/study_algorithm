import java.util.*;

class Time539 implements Comparable<Time539> {
    int h, m;

    public Time539(int h, int m) {
        this.h = h;
        this.m = m;
    }

    public int compareTo(Time539 time) {
        if (this.h != time.h)
            return this.h - time.h;
        return this.m - time.m;
    }

    public int getMinDiff(Time539 time) {
        return (this.h - time.h) * 60 + this.m - time.m;
    }
}

public class Leet539 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size(), answer = Integer.MAX_VALUE;
        Time539[] times = new Time539[2 * n];

        for (int i = 0; i < timePoints.size(); i++) {
            String[] tokens = timePoints.get(i).split(":");
            int h = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]);
            times[2 * i] = new Time539(h, m);
            times[2 * i + 1] = new Time539(h + 24, m);
        }

        Arrays.sort(times);
        for (int i = 1; i < times.length; i++)
            answer = Math.min(answer, times[i].getMinDiff(times[i - 1]));

        return answer;
    }
}
