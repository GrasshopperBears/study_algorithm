import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        HashMap<String, Integer> clothes = new HashMap<>();
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            clothes.clear();
            for (int i = 0; i < n; i++) {
                String[] tokens = br.readLine().split(" ");
                String type = tokens[1];
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }

            int count = 1;
            for (String type : clothes.keySet())
                count *= clothes.get(type) + 1;
            answer.append(count - 1).append("\n");
        }
        System.out.println(answer.toString());
    }
}
