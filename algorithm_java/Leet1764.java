import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Leet1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        HashSet<String> set = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        String name;
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (set.contains(name)) result.add(name);
        }

        Collections.sort(result);
        
        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            answer.append(result.get(i));
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}
