import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String tmp;
        int a, b;

        while (true) {
            tmp = br.readLine();
            a = Character.getNumericValue(tmp.charAt(0));
            b = Character.getNumericValue(tmp.charAt(2));
            if (a == 0 && b == 0) {
                break;
            }

            System.out.println(a + b);
        }
    }
}