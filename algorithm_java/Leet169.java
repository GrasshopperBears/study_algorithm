import java.util.HashMap;

class Leet169 {
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int targetCount = nums.length / 2;
        for (int num: nums) {
            int prevCount = count.getOrDefault(num, 0);
            count.put(num, prevCount+1);
            if (prevCount+1 > targetCount) return num;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {3,2,3})); // 3
        System.out.println(majorityElement(new int[] {2,2,1,1,1,2,2})); // 2
    }
}
