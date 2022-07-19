import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj10757 {
    private static int char2int(char a) {
        return a - '0';
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        StringBuilder answer = new StringBuilder();
        String a = tokens[0], b = tokens[1];
        int left = a.length() - 1, right = b.length() - 1, carry = 0, result;
        while (left >= 0 || right >= 0) {
            if (left < 0) {
                result = carry + char2int(b.charAt(right));
                right--;
            } else if (right < 0) {
                result = carry + char2int(a.charAt(left));
                left--;
            } else {
                result = carry + char2int(a.charAt(left)) + char2int(b.charAt(right));
                left--;
                right--;
            }
            answer.append(result % 10);
            carry = result / 10;
        }
        if (carry > 0) answer.append(carry);
        System.out.println(answer.reverse().toString());
    }
}
