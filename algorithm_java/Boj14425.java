import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Boj14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, answer = 0;
        HashSet<String> set = new HashSet<>();
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) answer++;
        }
        System.out.println(answer);
    }
}
