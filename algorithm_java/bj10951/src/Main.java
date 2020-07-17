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

        while ((tmp = br.readLine()) != null) {
            a = Character.getNumericValue(tmp.charAt(0));
            b = Character.getNumericValue(tmp.charAt(2));

            System.out.println(a + b);
        }
    }
}