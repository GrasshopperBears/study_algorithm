public class Leet1749 {
    public int maxAbsoluteSum(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        int current = 0;
        for (int num : nums) {
            current += num;
            if (current < num)
                current = num;
            max = Math.max(max, current);
        }

        current = 0;
        for (int num : nums) {
            current += num;
            if (current > num)
                current = num;
            min = Math.min(min, current);
        }

        return Math.max(Math.abs(min), Math.abs(max));
    }
}
