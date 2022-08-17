import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1929 {
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
        String[] tokens = br.readLine().split(" ");
        int m = Integer.parseInt(tokens[0]), n = Integer.parseInt(tokens[1]);
        StringBuilder answer = new StringBuilder();

        for (int i = m; i <= n; i++) {
            if (i > 1 && isPrime(i))
                answer.append(i).append("\n");
        }
        System.out.println(answer.toString());
    }
}
