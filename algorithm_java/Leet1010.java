public class Leet1010 {
    private int pickTwo(int n, int r) {
        if (r > n)
            return 0;
        return n % 2 == 0 ? (n / 2) * (n - 1) : ((n - 1) / 2) * n;
    }

    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        int result = 0;

        for (int t : time)
            remainders[t % 60]++;

        for (int i = 1; i < 30; i++)
            result += remainders[i] * remainders[60 - i];

        result += pickTwo(remainders[0], 2);
        result += pickTwo(remainders[30], 2);

        return result;
    }
}
