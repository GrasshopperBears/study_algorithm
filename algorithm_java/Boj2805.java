import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2805 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), left = 0, right = 0;
        int[] trees = new int[n];

        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int tree = Integer.parseInt(tokens[i]);
            trees[i] = tree;
            right = Math.max(right, tree);
        }
        Arrays.sort(trees);
        right--;

        while (left < right) {
            int mid = right - ((right - left) >> 1), total = 0;
            for (int i = n - 1; i >= 0 && trees[i] > mid && total < m; i--)
                total += trees[i] - mid;
            if (total >= m || total < 0)
                left = mid;
            else
                right = mid - 1;
        }
        System.out.println(left);
    }
}
