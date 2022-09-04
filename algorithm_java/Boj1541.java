import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1541 {
    private static int calc(String s) {
        int result = 0, current = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+') {
                result += current;
                current = 0;
            } else {
                current = current * 10 + c - '0';
            }
        }
        return result + current;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split("-");
        int[] sums = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++)
            sums[i] = calc(tokens[i]);

        int answer = sums[0];
        for (int i = 1; i < tokens.length; i++)
            answer -= sums[i];

        System.out.println(answer);
    }
}
