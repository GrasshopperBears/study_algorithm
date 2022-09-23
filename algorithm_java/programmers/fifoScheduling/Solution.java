package programmers.fifoScheduling;

public class Solution {
    public int solution(int n, int[] cores) {
        int left = 0, right = 50000;

        while (left < right) {
            int mid = (left + right) / 2, possibleJobs = 0;
            for (int core : cores) {
                possibleJobs += mid / core + 1;
                if (possibleJobs >= n)
                    break;
            }
            if (possibleJobs >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        for (int core : cores)
            n -= (left - 1) / core + 1;
        for (int i = 0; i < cores.length; i++) {
            if (left % cores[i] == 0) {
                n--;
                if (n == 0)
                    return i + 1;
            }
        }
        return -1;
    }
}
