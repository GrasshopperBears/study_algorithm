import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj14888 {
    private static int N, max, min;
    private static final int TYPES = 4;
    private static final int[] nums = new int[11];
    private static final int[] counts = new int[TYPES];

    private static void visit(int index, int curr) {
        if (index == N) {
            max = Math.max(max, curr);
            min = Math.min(min, curr);
            return;
        }
        int num = nums[index];

        for (int i = 0; i < TYPES; i++) {
            if (counts[i] == 0)
                continue;

            counts[i]--;
            if (i == 0)
                visit(index + 1, curr + num);
            else if (i == 1)
                visit(index + 1, curr - num);
            else if (i == 2)
                visit(index + 1, curr * num);
            else
                visit(index + 1, curr / num);
            counts[i]++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens;

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(tokens[i]);

        tokens = br.readLine().split(" ");
        for (int i = 0; i < TYPES; i++)
            counts[i] = Integer.parseInt(tokens[i]);

        visit(1, nums[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
