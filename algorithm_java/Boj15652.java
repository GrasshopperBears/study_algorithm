import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj15652 {
    private static int n, m;
    private static int[] pointers;

    private static int increasePointer(int idx) {
        if (pointers[idx] < n - 1 || idx == 0)
            pointers[idx]++;
        else
            pointers[idx] = increasePointer(idx - 1);
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

        for (int i = 0; i < nums.length; i++)
            nums[i] = i + 1;

        while (pointers[m - 1] < n) {
            for (int pointer : pointers)
                answer.append(nums[pointer]).append(' ');
            answer.append('\n');
            increasePointer(m - 1);
        }
        System.out.println(answer.toString());
    }
}
