class Leet1230 {
    public static double probabilityOfHeads(double[] prob, int target) {
        double[]dp = new double[target+1];
        dp[0] = 1;

        for (int coinIdx = 0; coinIdx < prob.length; coinIdx++) {
            double headProb = prob[coinIdx];
            double[]next = new double[target+1];
            next[0] = dp[0] * (1 - headProb);

            for (int curr = 1; curr <= target; curr++) {
                next[curr] = dp[curr-1] * headProb + dp[curr] * (1 - headProb);
            }
            dp = next;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(probabilityOfHeads(new double[] {0.4}, 1)); // 0.40000
        System.out.println(probabilityOfHeads(new double[] {0.5,0.5,0.5,0.5,0.5}, 0)); // 0.03125
    }
}