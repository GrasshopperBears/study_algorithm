import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), K = Integer.parseInt(tokens[1]), currSum = 0, result = -10000000, num;
        int[] nums = new int[N];
        tokens = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(tokens[i]);
            nums[i] = num;
            currSum += num;
            if (i < K-1) continue;
            if (i >= K) currSum -= nums[i-K];
            result = Math.max(result, currSum);
        }
        System.out.println(result);
    }
}
