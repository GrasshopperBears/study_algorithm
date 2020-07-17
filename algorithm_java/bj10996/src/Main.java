import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        String[] star_types = {"*", " "};

        for (int i = 1; i < num; i++) {
            if (i % 2 == 1) {
                star_types[0] += " ";
                star_types[1] += "*";
            } else {
                star_types[0] += "*";
                star_types[1] += " ";
            }
        }

        for (int i = 0; i < 2 * num; i++) {
            System.out.println(star_types[i % 2]);
        }
    }
}
