import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1074 {
    private static int order(int n, int r, int c) {
        if (n == 2)
            return 2 * r + c;
        int half = n / 2;
        if (r < half && c < half)
            return order(half, r, c);

        int block = half * half;
        if (r >= half && c >= half) {
            return 3 * block + order(half, r - half, c - half);
        } else if (r >= half) {
            return 2 * block + order(half, r - half, c);
        } else {
            return block + order(half, r, c - half);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), r = Integer.parseInt(tokens[1]), c = Integer.parseInt(tokens[2]);
        System.out.println(order((int) Math.pow(2, n), r, c));
    }
}
