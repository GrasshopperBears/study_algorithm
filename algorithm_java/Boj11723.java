import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11723 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] set = new boolean[21];
        int ops = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int l = 0; l < ops; l++) {
            String[] tokens = br.readLine().split(" ");
            String op = tokens[0];
            int num = tokens.length > 1 ? Integer.parseInt(tokens[1]) : 0;

            if (op.equals("add")) {
                set[num] = true;
            } else if (op.equals("remove")) {
                set[num] = false;
            } else if (op.equals("check")) {
                answer.append(set[num] ? 1 : 0).append("\n");
            } else if (op.equals("toggle")) {
                set[num] = !set[num];
            } else if (op.equals("all")) {
                Arrays.fill(set, true);
            } else if (op.equals("empty")) {
                Arrays.fill(set, false);
            }
        }
        System.out.println(answer.toString());
    }
}
