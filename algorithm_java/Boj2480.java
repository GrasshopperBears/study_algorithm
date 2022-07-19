import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2480 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]), c = Integer.parseInt(tokens[2]), answer;
        if (a == b && b == c) answer = 10000 + a * 1000;
        else if (a != b && b != c && c != a) answer = 100 * Math.max(a, Math.max(b, c));
        else answer = 1000 + 100 * (a == b || a == c ? a : b);
        System.out.println(answer);
    }
}
