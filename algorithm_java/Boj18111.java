import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), b = Integer.parseInt(tokens[2]);
        int maxHeight = 0;
        long minTime = Long.MAX_VALUE;
        int[] map = new int[n * m];

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < m; j++)
                map[m * i + j] = Integer.parseInt(tokens[j]);
        }
        Arrays.sort(map);

        for (int h = 256; h >= 0; h--) {
            long currTime = 0;
            int currInventory = b;
            for (int i = n * m - 1; i >= 0; i--) {
                int diff = h - map[i];
                if (diff < 0) {
                    currTime += 2 * (-diff);
                    currInventory -= diff;
                } else if (diff > 0) {
                    currInventory -= diff;
                    if (currInventory < 0)
                        break;
                    currTime += diff;
                }
            }
            if (currInventory >= 0 && currTime < minTime) {
                minTime = currTime;
                maxHeight = h;
            }
        }
        System.out.printf("%d %d", minTime, maxHeight);
    }
}
