class Solution {
    static int alphabets = 26, charBase = 'a';

    public static String shiftingLetters(String s, int[] shifts) {
        StringBuilder answer = new StringBuilder();
        int shiftCount = 0;

        for (int i = shifts.length - 1; i >= 0; i--) {
            shiftCount += shifts[i];
            shiftCount %= alphabets;
            int shiftedChar = ((int)s.charAt(i) - charBase + shiftCount) % alphabets + charBase;
            answer.append((char)shiftedChar);
        }
        return answer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[] {3,5,9})); // "rpl"
        System.out.println(shiftingLetters("aaa", new int[] {1,2,3})); // "gfd"
    }
}
