import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] digits = new int[5];
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0)
                return;
            int i = 0, left = 0;
            for (; i < 5 && num > 0; i++) {
                digits[i] = num % 10;
                num /= 10;
            }
            i--;
            boolean result = true;
            while (left <= i) {
                if (digits[left++] != digits[i--]) {
                    result = false;
                    break;
                }
            }
            System.out.println(result ? "yes" : "no");
        }
    }
}
