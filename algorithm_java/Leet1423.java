public class Leet1423 {
    public static int maxScore(int[] cardPoints, int k) {
        int maxScore = 0, currentSum = 0, left = k - 1, right = cardPoints.length - 1;

        for (int i = 0; i < k; i++) {
            maxScore += cardPoints[i];
            currentSum += cardPoints[i];
        }
        for (int i = 0; i < k; i++) {
            currentSum = currentSum - cardPoints[left--] + cardPoints[right--];
            maxScore = Math.max(maxScore, currentSum);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        System.out.println(maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3)); // 12
        System.out.println(maxScore(new int[] { 2, 2, 2 }, 2)); // 4
        System.out.println(maxScore(new int[] { 9, 7, 7, 9, 7, 7, 9 }, 7)); // 55
    }
}
