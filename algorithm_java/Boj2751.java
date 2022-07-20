import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2751 {
    static int[] tmp = new int[1000000];

    public static void merge(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2, i = left, j = mid, idx = left;

        while (i < mid || j < right) {
            if (i == mid) {
                tmp[idx++] = arr[j++];
            } else if (j == right || arr[i] <= arr[j]) {
                tmp[idx++] = arr[i++];
            } else {
                tmp[idx++] = arr[j++];
            }
        }

        for (idx = left; idx < right; idx++) {
            arr[idx] = tmp[idx];
        }
    }

    public static void sort(int[] arr, int from, int to) {
        if (to - from <= 1) return;
        int mid = from + (to - from) / 2;
        sort(arr, from, mid);
        sort(arr, mid, to);
        merge(arr, from, to);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        sort(nums, 0, size);
        for (int i = 0; i < size; i++) {
            answer.append(nums[i]);
            answer.append("\n");
        }
        System.out.println(answer.toString());
    }
}
