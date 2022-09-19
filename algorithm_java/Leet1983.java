public class Leet1983 {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length, maxDist = 0;
        int[] nums1Sum = new int[n + 1];
        int[] nums2Sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            nums1Sum[i + 1] = nums1Sum[i] + nums1[i];
            nums2Sum[i + 1] = nums2Sum[i] + nums2[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + maxDist + 1; j <= n; j++) {
                if (nums1Sum[j] - nums1Sum[i] == nums2Sum[j] - nums2Sum[i]) {
                    maxDist = Math.max(maxDist, j - i);
                }
            }
        }
        return maxDist;
    }
}
