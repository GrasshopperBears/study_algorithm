package programmers.move110;

import java.util.*;

class Chars {
    int pos;
    boolean isOne;

    public Chars(int pos, boolean isOne) {
        this.pos = pos;
        this.isOne = isOne;
    }
}

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        ArrayList<Integer> positions = new ArrayList<>();
        Stack<Chars> stack = new Stack<>();

        for (int tc = 0; tc < s.length; tc++) {
            StringBuilder result = new StringBuilder();
            int lastZero = -1;
            String str = s[tc];
            positions.clear();
            stack.clear();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '1' || stack.size() < 2) {
                    stack.push(new Chars(i, c == '1'));
                } else {
                    Chars p = stack.peek();
                    if (p.isOne) {
                        Chars pp = stack.get(stack.size() - 2);
                        if (pp.isOne) {
                            stack.pop();
                            positions.add(stack.pop().pos);
                            continue;
                        }
                    }
                    stack.push(new Chars(i, false));
                }
            }
            for (Chars chars : stack) {
                if (!chars.isOne)
                    lastZero = chars.pos;
            }
            if (lastZero >= 0) {
                for (Chars chars : stack) {
                    result.append(chars.isOne ? '1' : '0');
                    if (chars.pos == lastZero) {
                        for (int i = 0; i < positions.size(); i++)
                            result.append("110");
                    }
                }
            } else {
                for (int i = 0; i < positions.size(); i++)
                    result.append("110");
                for (Chars chars : stack)
                    result.append(chars.isOne ? '1' : '0');
            }
            answer[tc] = result.toString();
        }
        return answer;
    }
}
