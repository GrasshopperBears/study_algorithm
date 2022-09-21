import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Boj1629 {
    private static HashMap<Integer, Integer> dp = new HashMap<>();

    private static long pow(int a, int b, int c) {
        if (b == 0)
            return 1;
        if (b == 1)
            return a % c;
        if (dp.containsKey(b))
            return dp.get(b);
        int half = b / 2;
        long result = pow(a, half, c);
        result = (result * result) % c;
        if (half << 1 != b)
            result = (result * a) % c;
        dp.put(b, (int) result);
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]), c = Integer.parseInt(tokens[2]);
        System.out.println(pow(a, b, c));
    }
}
