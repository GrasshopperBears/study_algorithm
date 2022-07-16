import java.util.*;

class Solution {
    int answer = 0;
    List<String> list;

    private void use(int index, Set<Character> set) {
        if (index == list.size()) {
            if (set.size() > answer) answer = set.size();
            return;
        }
        use(index+1, new HashSet<>(set));

        String current = list.get(index);
        for (int i = 0; i < current.length(); i++) {
            char c = current.charAt(i);
            if (set.contains(c)) return;
            set.add(c);
        }
        use(index+1, set);
    }

    public int maxLength(List<String> arr) {
        list = arr;
        use(0, new HashSet<Character>());
        return answer;
    }

    public void main(String[] args) {
        System.out.println(maxLength(List.of(new String[]{"un", "iq", "ue"}))); // 4
        System.out.println(maxLength(List.of(new String[]{"cha","r","act","ers"}))); // 6
        System.out.println(maxLength(List.of(new String[]{"abcdefghijklmnopqrstuvwxyz"}))); // 26
    }
}