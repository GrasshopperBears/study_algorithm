import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj6064 {
    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            String[] tokens = br.readLine().split(" ");
            int m = Integer.parseInt(tokens[0]), n = Integer.parseInt(tokens[1]);
            int x = Integer.parseInt(tokens[2]) - 1, y = Integer.parseInt(tokens[3]) - 1;
            int gcd = m > n ? gcd(m, n) : gcd(n, m);
            int lcm = m * n / gcd;
            int curr = x;

            while (curr < lcm) {
                if (curr % n == y)
                    break;
                curr += m;
            }
            answer.append(curr < lcm ? curr + 1 : -1).append('\n');
        }
        System.out.println(answer.toString());
    }
}
