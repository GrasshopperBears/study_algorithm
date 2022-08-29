import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1676 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int two = 0, five = 0;

        for (int i = 1; i <= n; i++) {
            int current = i;
            while (true) {
                if (current % 5 == 0) {
                    current /= 5;
                    five++;
                } else {
                    break;
                }
            }
            while (true) {
                if ((current & 1) == 0) {
                    two++;
                    current >>= 1;
                } else {
                    break;
                }
            }
        }
        System.out.println(Math.min(two, five));
    }
}
