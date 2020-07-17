import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num2_one = num2 % 10;
        int num2_ten = ((num2 - num2_one) / 10) % 10;
        int num3_hundred = ((num2 - num2_ten * 10 - num2_one) / 100) % 10;

        System.out.println(num1 * num2_one);
        System.out.println(num1 * num2_ten);
        System.out.println(num1 * num3_hundred);
        System.out.println(num1 * num2);
    }
}