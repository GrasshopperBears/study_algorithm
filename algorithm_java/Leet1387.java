import java.util.*;

class Leet1387 {
    static HashMap<Integer, Integer> dp = new HashMap<>();

    private static int calc(int num) {
        if (dp.containsKey(num)) return dp.get(num);
        int result = num % 2 == 0 ? calc(num / 2) : calc(3 * num + 1);
        dp.put(num, ++result);
        return result;
    }

    public static int getKth(int lo, int hi, int k) {
        int[][] answer = new int[hi-lo+1][2];
        dp.put(1, 1);
        for (int i = 0; i < answer.length; i++) {
            answer[i][0] = lo+i;
        }
        for (int i = hi; i >= lo; i--) {
            answer[i-lo][1] = calc(i);
        }
        Arrays.sort(answer, (a, b) -> a[1] - b[1]);
        return answer[k-1][0];
    }

    public static void main(String[] args) {
        System.out.println(getKth(12, 15, 2)); // 13
        System.out.println(getKth(7, 11, 4)); // 7
        System.out.println(getKth(1, 1000, 777)); // 570
    }
}
