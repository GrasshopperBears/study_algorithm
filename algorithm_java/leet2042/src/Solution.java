class Solution {
    public static boolean areNumbersAscending(String s) {
        int prevIdx = 0, currIdx, last = -1;
        String sub;
        s += " ";

        while (true) {
            currIdx = s.indexOf(' ', prevIdx);
            if (currIdx < 0) break;

            sub = s.substring(prevIdx, currIdx);
            prevIdx = currIdx + 1;
            try {
                int parsed = Integer.parseInt(sub);
                if (parsed <= last) return false;
                last = parsed;
            } catch (Exception ignored) {
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles")); // true
        System.out.println(areNumbersAscending("hello world 5 x 5")); // false
        System.out.println(areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s")); // false
    }
}