package programmers.starSequence;

import java.util.*;

public class Solution {
    public int solution(int[] a) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            if (map.containsKey(num)) {
                ArrayList<Integer> el = map.get(num);
                int last = el.get(el.size() - 1);
                if (i - last > 2 && a[i - 1] != num)
                    el.add(i - 1);
                else if (i < a.length - 1 && a[i + 1] != num)
                    el.add(i);
            } else {
                ArrayList<Integer> el = new ArrayList<>();
                if (i > 0 && a[i - 1] != num)
                    el.add(i - 1);
                else if (i < a.length - 1 && a[i + 1] != num)
                    el.add(i);
                if (el.size() > 0)
                    map.put(num, el);
            }
        }

        int maxLen = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> el : map.entrySet())
            maxLen = Math.max(maxLen, el.getValue().size());

        return maxLen * 2;
    }
}
