import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1934 {
    private static int euc(int a, int b) {
        if (b == 0) return a;
        return euc(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), a, b;
        String[] tokens;
        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[1]);
            System.out.printf("%d\n", a * b / euc(a, b));
        }
    }
}
