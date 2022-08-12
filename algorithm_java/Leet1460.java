import java.util.Arrays;

public class Leet1460 {
    public static boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (target[i] != arr[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 })); // true
        System.out.println(canBeEqual(new int[] { 7 }, new int[] { 7 })); // true
        System.out.println(canBeEqual(new int[] { 3, 7, 9 }, new int[] { 3, 7, 11 })); // false
    }
}
