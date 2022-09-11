import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj5525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine()), answer = 0, currFrom = -1;
        String s = br.readLine();

        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                if (currFrom < 0) {
                    currFrom = i;
                } else if (s.charAt(i - 1) == c) {
                    answer += Math.max(0, (i - currFrom) / 2 - n + 1);
                    currFrom = i;
                }
            } else if (currFrom >= 0 && s.charAt(i - 1) == c) {
                answer += Math.max(0, (i - currFrom - 1) / 2 - n + 1);
                currFrom = -1;
            }
        }
        if (currFrom >= 0)
            answer += Math.max(0, (m - currFrom - (s.charAt(m - 1) == 'I' ? 0 : 1)) / 2 - n + 1);

        System.out.println(answer);
    }
}
