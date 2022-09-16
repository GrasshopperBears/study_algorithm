import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj5430 {
    private static String arrToStr(int[] arr, int left, int right, boolean isLeft) {
        StringBuilder result = new StringBuilder();
        result.append('[');

        if (isLeft) {
            for (int i = left; i <= right; i++) {
                result.append(arr[i]);
                if (i < right)
                    result.append(',');
            }
        } else {
            for (int i = right; i >= left; i--) {
                result.append(arr[i]);
                if (i > left)
                    result.append(',');
            }
        }
        result.append(']');
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            String ops = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String numsStr = br.readLine();
            String[] tokens = numsStr.substring(1, numsStr.length() - 1).split(",");

            int left = 0, right = n - 1;
            boolean isLeft = true, error = false;

            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(tokens[i]);

            for (int i = 0; i < ops.length(); i++) {
                char op = ops.charAt(i);
                if (op == 'R') {
                    isLeft = !isLeft;
                } else {
                    if (left > right) {
                        error = true;
                        break;
                    }
                    if (isLeft)
                        left++;
                    else
                        right--;
                }
            }

            if (error)
                answer.append("error");
            else
                answer.append(arrToStr(nums, left, right, isLeft));

            answer.append('\n');
        }
        System.out.println(answer.toString());
    }
}
