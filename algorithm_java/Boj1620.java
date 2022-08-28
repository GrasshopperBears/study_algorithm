import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]);
        StringBuilder answer = new StringBuilder();
        String[] indices = new String[n];
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String pokemon = br.readLine();
            indices[i] = pokemon;
            map.put(pokemon, i);
        }
        for (int i = 0; i < m; i++) {
            String find = br.readLine();
            if (find.charAt(0) <= 57)
                answer.append(indices[Integer.parseInt(find) - 1]).append("\n");
            else
                answer.append(map.get(find) + 1).append("\n");
        }
        System.out.println(answer.toString());
    }
}
