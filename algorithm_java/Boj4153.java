import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj4153 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] tokens = br.readLine().split(" ");
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);
            if (a + b + c == 0)
                return;
            int max = Math.max(a, Math.max(b, c));
            boolean result;
            if (a == max)
                result = a * a == b * b + c * c;
            else if (b == max)
                result = b * b == a * a + c * c;
            else
                result = c * c == a * a + b * b;
            System.out.println(result ? "right" : "wrong");
        }
    }
}
