import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(tokens[i]);
            sum += num * num;
        }
        System.out.println(sum % 10);
    }
}
