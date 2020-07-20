import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();
        sc.close();
        ArrayList<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < line.length(); i++) {
            numberList.add(Character.getNumericValue(line.charAt(i)));
        }

        numberList.sort((o1, o2) -> o2 - o1);
        for (int i: numberList) {
            System.out.print(i);
        }
    }
}
