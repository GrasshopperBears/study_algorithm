import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        String string = String.join("", Collections.nCopies(2 * num - 1, "*"));
        System.out.println(string);

        for (int i = 1; i < 2 * num - 1; i++) {
            if (i < num) {
                string = string.replaceFirst("\\*\\*", " ");
            } else {
                string += "**";
                string = string.replaceFirst("\\s", "");
            }
            System.out.println(string);
        }
    }
}
