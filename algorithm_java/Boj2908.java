import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2908 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num1 = "";
        String num2 = "";
        boolean swtch = true;
        int val;

        while ((val = br.read()) != 10) {
            if (val == 32) {
                swtch = false;
            } else if (swtch) {
                num1 = (char)val + num1;
            } else {
                num2 = (char)val + num2;
            }

        }

        System.out.println(Integer.parseInt(num1) > Integer.parseInt(num2) ? num1 : num2);
    }
}
