import java.util.*;

class Solution {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashSet<Integer> countSet = new HashSet<>();

        for (int num: arr) {
            countMap.put(num, countMap.containsKey(num) ? countMap.get(num)+1 : 1);
        }
        for (int count: countMap.values()) {
            if (countSet.contains(count)) return false;
            countSet.add(count);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[] {1,2,2,1,1,3})); // true
        System.out.println(uniqueOccurrences(new int[] {1,2})); // false
        System.out.println(uniqueOccurrences(new int[] {-3,0,1,-3,1,1,1,-3,10,0})); // true
    }
}
