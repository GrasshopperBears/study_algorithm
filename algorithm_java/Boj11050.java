import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11050 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), k = Integer.parseInt(tokens[1]), result = 1;
        if (n-k < k) k = n-k;

        for (int i = 1; i <= k; i++) {
            result *= (n-i+1);
            result /= i;
        }
        System.out.println(result);
    }
}
