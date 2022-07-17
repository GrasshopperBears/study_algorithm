import java.util.Scanner;

public class Boj1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int nth = 0, curr = 666;

        while (nth < num) {
            int tmp = curr;
            while (tmp >= 666 && tmp % 1000 != 666) {
                tmp /= 10;
            }
            if (tmp % 1000 == 666) {
                nth++;
            }
            curr++;
        }
        System.out.println(curr - 1);
    }
}
