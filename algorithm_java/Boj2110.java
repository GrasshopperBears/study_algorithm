import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), C = Integer.parseInt(tokens[1]), left, right, mid, remain, prev;
        int[] homes = new int[N];

        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        left = homes[1] - homes[0];
        for (int i = 1; i < N-1; i++) {
            left = Math.min(left, homes[i+1] - homes[i]);
        }
        right = homes[N-1] - homes[0];

        while (left <= right) {
            mid = (left+right) / 2;
            remain = C-1;
            prev = homes[0];
            for (int i = 1; i < N; i++) {
                if (homes[i] - prev >= mid) {
                    remain--;
                    prev = homes[i];
                }
            }
            if (remain > 0) right = mid-1;
            else left = mid+1;
        }
        System.out.println(right);
    }
}
