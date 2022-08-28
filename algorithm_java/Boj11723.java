import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int set = 0, ops = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int l = 0; l < ops; l++) {
            String[] tokens = br.readLine().split(" ");
            String op = tokens[0];
            int num = tokens.length > 1 ? Integer.parseInt(tokens[1]) : 0;

            if (op.equals("add")) {
                set |= 1 << (num - 1);
            } else if (op.equals("remove")) {
                set &= ~(1 << (num - 1));
            } else if (op.equals("check")) {
                answer.append((set & (1 << (num - 1))) > 0 ? 1 : 0).append("\n");
            } else if (op.equals("toggle")) {
                set ^= 1 << (num - 1);
            } else if (op.equals("all")) {
                set = -1;
            } else if (op.equals("empty")) {
                set = 0;
            }
        }
        System.out.println(answer.toString());
    }
}
