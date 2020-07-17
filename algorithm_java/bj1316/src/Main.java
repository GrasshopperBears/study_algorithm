import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 0; i < caseNum; i++) {
            String ip = br.readLine().trim();

            if (ip.length() == 1) {
                answer++;
                continue;
            }

            int j;
            boolean[] checker = new boolean[26];
            Arrays.fill(checker, false);
            for (j = 1; j < ip.length(); j++) {
                if (checker[(int)ip.charAt(j) - 97]) {
                    break;
                }
                if (ip.charAt(j) != ip.charAt(j - 1)) {
                    checker[(int)ip.charAt(j - 1) - 97] = true;
                }
            }

            if (j != ip.length()) continue;
            answer++;
        }

        System.out.println(answer);
    }
}
