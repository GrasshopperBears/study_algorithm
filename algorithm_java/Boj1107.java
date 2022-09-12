import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj1107 {
    private static HashSet<Integer> broken = new HashSet<>();

    private static boolean isPossible(int num) {
        if (num == 0)
            return !broken.contains(0);
        while (num > 0) {
            int last = num % 10;
            if (broken.contains(last))
                return false;
            num /= 10;
        }
        return true;
    }

    private static int getDigits(int num) {
        int digits = num == 0 ? 1 : 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        return digits;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        int left = n, right = n;

        if (m > 0) {
            String[] tokens = br.readLine().split(" ");
            for (int i = 0; i < m; i++)
                broken.add(Integer.parseInt(tokens[i]));
        }
        if (n == 100 || m == 10) {
            System.out.println(Math.abs(n - 100));
            return;
        }

        int answer = Integer.MAX_VALUE;
        while (true) {
            if (isPossible(left))
                answer = getDigits(left) + Math.abs(left - n);
            if (isPossible(right))
                answer = Math.min(answer, getDigits(right) + Math.abs(right - n));
            if (answer < Integer.MAX_VALUE) {
                System.out.println(Math.min(answer, Math.abs(n - 100)));
                return;
            }

            if (left > 0)
                left--;
            right++;
        }
    }
}
