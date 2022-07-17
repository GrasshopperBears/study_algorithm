import java.util.Stack;


class Solution {
    public static boolean canBeValid(String s, String locked) {
        Stack<Integer> lockedOpen = new Stack<>();
        Stack<Integer> notLocked = new Stack<>();
        int length = s.length();

        if (length % 2 > 0) return false;

        for (int i = 0; i < length; i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    if (lockedOpen.size() > 0) {
                        lockedOpen.pop();
                    } else if (notLocked.size() > 0) {
                        notLocked.pop();
                    } else {
                        return false;
                    }
                    continue;
                }
                lockedOpen.push(i);
            } else {
                notLocked.push(i);
            }
        }

        if (lockedOpen.size() > notLocked.size()) return false;
        while (lockedOpen.size() > 0) {
            if (lockedOpen.pop() > notLocked.pop()) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeValid("))()))", "010100")); // true
        System.out.println(canBeValid("()()", "0000")); // true
        System.out.println(canBeValid(")", "0")); // false
        System.out.println(canBeValid("())()))()(()(((())(()()))))((((()())(())",
                                    "1011101100010001001011000000110010100101")); // true
    }
}