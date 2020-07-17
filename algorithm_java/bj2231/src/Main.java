import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();
        int num = Integer.parseInt(numStr);
        br.close();
        int digitSum;
        int tmp;
        String nines = "";

        if (num < 10) {
            System.out.println(num % 2 == 0 ? num / 2 : 0);
            return;
        }

        for (int i = 0; i < numStr.length(); i++) {
            nines += "9";
        }
        for (int i = num - Integer.parseInt(nines); i < num; i++) {
            digitSum = 0; tmp = i;
            while (tmp > 0) {
                digitSum += (tmp %10);
                tmp /= 10;
            }
            if (num == i + digitSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}
