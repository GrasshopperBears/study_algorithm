import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");
        int min = Integer.parseInt(tokens[0]), max = min, num;

        for (int i = 1; i < n; i++) {
            num = Integer.parseInt(tokens[i]);
            if (num > max) max = num;
            else if (num < min) min = num;
        }
        System.out.println(min * max);
    }
}
