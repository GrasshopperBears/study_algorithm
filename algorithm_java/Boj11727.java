import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), pp = 1, p = 1, tmp;

        for (int i = 2; i <= n; i++) {
            tmp = p;
            p = (p + 2 * pp) % 10007;
            pp = tmp % 10007;
        }
        System.out.println(p);
    }
}
