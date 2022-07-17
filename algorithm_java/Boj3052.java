import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj3052 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] remainder = new int[42];
        Arrays.fill(remainder, 0);
        int tmp;
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            tmp = Integer.parseInt(br.readLine());
            remainder[tmp % 42]++;
        }

        for(int num: remainder) {
            if (num != 0) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
