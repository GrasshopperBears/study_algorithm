import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2447 {
    public static String draw(int r, int c, int n) {
        if ((r/n) % 3 == 1 && (c/n) % 3 == 1) return " ";
        if (n / 3 == 0) return "*";
        return draw(r, c, n/3);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer.append(draw(i, j, N));
            }
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}
