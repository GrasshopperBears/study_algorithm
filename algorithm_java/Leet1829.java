public class Leet1829 {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] result = new int[nums.length];
        int current = 0, max = (int) Math.pow(2, maximumBit) - 1;

        for (int i = 0; i < result.length; i++) {
            current ^= nums[i];
            result[i] = current ^ max;
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int tmp = result[left];
            result[left++] = result[right];
            result[right--] = tmp;
        }
        return result;
    }
}
