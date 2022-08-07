import java.io.*;

public class Boj2096 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] prevMin = new int[3], prevMax = new int[3];
        String[] tokens;

        for (int i = 0; i < n; i++) {
            tokens = br.readLine().split(" ");
            int[] nextMin = new int[3];
            int[] nextMax = new int[3];
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);
            int c = Integer.parseInt(tokens[2]);

            nextMin[0] = Math.min(prevMin[0], prevMin[1]);
            nextMin[1] = Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));
            nextMin[2] = Math.min(prevMin[1], prevMin[2]);

            nextMax[0] = Math.max(prevMax[0], prevMax[1]);
            nextMax[1] = Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
            nextMax[2] = Math.max(prevMax[1], prevMax[2]);

            nextMin[0] += a;
            nextMin[1] += b;
            nextMin[2] += c;
            
            nextMax[0] += a;
            nextMax[1] += b;
            nextMax[2] += c;

            prevMin = nextMin;
            prevMax = nextMax;
        }
        System.out.printf("%d %d", Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2])), Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2])));
    }
}
