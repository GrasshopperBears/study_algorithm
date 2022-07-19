package leetLibrary;

public class Utils {
    public static void printArray(int[] arr) {
        System.out.printf("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d", arr[i]);
            if (i < arr.length-1) System.out.printf(", ");
        }
        System.out.printf("]\n");
    }
}
