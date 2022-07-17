import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2562 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = -1, max = 0;
        int tmp;

        for (int i = 1; i < 10; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (tmp > max) {
                idx = i;
                max = tmp;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}
