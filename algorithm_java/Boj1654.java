import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int k = Integer.parseInt(tokens[0]), n = Integer.parseInt(tokens[1]), left = 1, right = 1;
        int[] lans = new int[k];

        for (int i = 0; i < k; i++) {
            int lan = Integer.parseInt(br.readLine());
            lans[i] = lan;
            right = Math.max(right, lan);
        }

        while (left < right) {
            int mid = right - ((right - left) >> 1);
            int count = 0;
            for (int i = 0; i < k && count < n; i++)
                count += lans[i] / mid;
            if (count >= n || count < 0)
                left = mid;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }
}
