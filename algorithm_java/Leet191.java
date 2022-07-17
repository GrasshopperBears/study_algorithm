class Leet191 {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        boolean isNegative = n < 0;
        int answer = 0;
        if (isNegative) n ^= -1;

        while (n > 0) {
            answer += n & 1;
            // answer += n % 2;
            n >>= 1;
        }
        return isNegative ? 32 - answer : answer;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(Integer.parseUnsignedInt("00000000000000000000000000001011", 2))); // 3
        System.out.println(hammingWeight(Integer.parseUnsignedInt("00000000000000000000000010000000", 2))); // 1
        System.out.println(hammingWeight(Integer.parseUnsignedInt("11111111111111111111111111111101", 2))); // 31
    }
}
