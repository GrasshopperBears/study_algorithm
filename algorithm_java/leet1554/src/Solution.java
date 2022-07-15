class Solution {
    public static boolean differByOne(String[] dict) {
        int size = dict.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i+1; j < size; j++) {
                String left = dict[i];
                String right = dict[j];
                boolean diff = false;
                for (int k = 0; k < left.length(); k++) {
                    if (left.charAt(k) != right.charAt(k)) {
                        diff = !diff;
                        if (!diff) break;
                    }
                }
                if (diff) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(differByOne(new String[]{"abcd", "acbd", "aacd"}));  // true
        System.out.println(differByOne(new String[]{"ab", "cd", "yz"}));  // false
        System.out.println(differByOne(new String[]{"abcd", "cccc", "abyd", "abab"}));  // true
    }
}