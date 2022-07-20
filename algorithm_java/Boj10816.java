import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        int N, M, num;
        String[] tokens;
        StringBuilder answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(tokens[i]);
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        M = Integer.parseInt(br.readLine());
        tokens = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            answer.append(map.getOrDefault(Integer.parseInt(tokens[i]), 0));
            answer.append(" ");
        }
        System.out.println(answer.toString());
    }
}
