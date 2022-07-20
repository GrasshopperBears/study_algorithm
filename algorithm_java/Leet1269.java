import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Leet1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]), answer;

        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(tokens[i]));
        }

        answer = set.size();
        tokens = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            if (!set.contains(Integer.parseInt(tokens[i]))) answer++;
            else answer--;
        }
        System.out.println(Math.abs(answer));
    }
}
