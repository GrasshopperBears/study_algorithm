import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        String str = "";

        for (int i = 0; i < 2 * num - 1; i++) {
            if (i < num) {
                str += "*";
            } else {
                str = str.replaceFirst("\\*", "");
            }
            System.out.println(str);
        }
    }
}
