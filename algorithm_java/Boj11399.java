import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n];
        long time = 0;
        String[] tokens = br.readLine().split(" ");

        for (int i = 0; i < n; i++)
            times[i] = Integer.parseInt(tokens[i]);
        Arrays.sort(times);

        for (int i = 0; i < n; i++)
            time += times[i] * (n - i);

        System.out.println(time);
    }
}
