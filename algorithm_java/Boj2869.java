import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2869 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int a = Integer.parseInt(tokens[0]), b = Integer.parseInt(tokens[1]);
        double v = Double.parseDouble(tokens[2]);
        System.out.println((int)Math.ceil((v-a) / (a-b)) + 1);
    }
}
