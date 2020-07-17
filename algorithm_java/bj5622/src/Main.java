import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val;
        int sum = 0;

        while ((val = br.read() - 65) != -55) {
            sum += (val / 3 + 3);
            if (val == 18 || val == 21 || val == 24 || val == 25) sum--;
        }

        System.out.println(sum);
    }
}
