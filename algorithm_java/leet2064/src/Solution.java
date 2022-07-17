class Solution {
    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int num: arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = findMax(quantities);
        while (left <= right) {
            int mid = (left+right) / 2, stores = 0;
            for (int quantity: quantities) {
                stores += quantity / mid; // or, stores += (quantity + mid - 1) / mid
                if (quantity % mid > 0) stores++;
                if (stores > n) break;
            }
            if (stores > n) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(minimizedMaximum(6, new int[] {11, 6})); // 3
        System.out.println(minimizedMaximum(7, new int[] {15, 10, 10})); // 5
        System.out.println(minimizedMaximum(1, new int[] {100000})); // 100000
    }
}
