import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1978 {
    private static boolean isPrime(int num) {
        int bound = (int) (Math.sqrt(num));
        for (int i = 2; i <= bound; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), answer = 0;
        String[] tokens = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokens[i]);
            if (num > 1 && isPrime(num))
                answer++;
        }
        System.out.println(answer);
    }
}
