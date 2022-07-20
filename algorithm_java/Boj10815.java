import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N, M;
        String[] tokens;
        HashSet<String> cards = new HashSet<>();
        N = Integer.parseInt(br.readLine());
        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cards.add(tokens[i]);
        }
        M = Integer.parseInt(br.readLine());
        tokens = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (cards.contains(tokens[i])) answer.append(1);
            else answer.append(0);
            answer.append(" ");
        }
        System.out.println(answer.toString());
    }
}
