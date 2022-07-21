import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj5086 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens;
        int a, b;

        while (true) {
            tokens = br.readLine().split(" ");
            a = Integer.parseInt(tokens[0]);
            b = Integer.parseInt(tokens[1]);
            if (a == 0 && b == 0) return;
            if (a % b == 0) System.out.println("multiple");
            else if (b % a == 0) System.out.println("factor");
            else System.out.println("neither");
        }
    }
}
