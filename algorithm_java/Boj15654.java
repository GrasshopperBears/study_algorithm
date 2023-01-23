import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj15654 {
    private static int n, m;
    private static int[] pointers;

    private static int increasePointer(int idx) {
        if (pointers[idx] < n - 1 || idx == 0)
            pointers[idx]++;
        else
            pointers[idx] = increasePointer(idx - 1) + 1;
        return pointers[idx];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        m = Integer.parseInt(tokens[1]);
        int[] nums = new int[n];
        pointers = new int[m];

        tokens = br.readLine().split(" ");
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.parseInt(tokens[i]);
        Arrays.sort(nums);

        for (int i = 0; i < pointers.length; i++)
            pointers[i] = i;

        while (pointers[0] <= n - m) {
            for (int pointer : pointers)
                answer.append(nums[pointer]).append(' ');
            answer.append('\n');
            increasePointer(m - 1);
        }
        System.out.println(answer.toString());
    }
}
