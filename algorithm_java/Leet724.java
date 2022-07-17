import java.util.Arrays;

class Leet724 {
    public static int pivotIndex(int[] nums) {
        int right = Arrays.stream(nums).sum(), left = 0, idx = 0;

        while (idx < nums.length) {
            right -= nums[idx];
            if (left == right) return idx;
            left += nums[idx++];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6})); // 3
        System.out.println(pivotIndex(new int[] {1,2,3})); // -1
        System.out.println(pivotIndex(new int[] {2,1,-1})); // 0
    }
}
