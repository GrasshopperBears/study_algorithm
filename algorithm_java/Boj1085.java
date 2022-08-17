import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1085 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int x = Integer.parseInt(tokens[0]), y = Integer.parseInt(tokens[1]);
        int w = Integer.parseInt(tokens[2]), h = Integer.parseInt(tokens[3]);
        System.out.println(Math.min(Math.min(x, w - x), Math.min(y, h - y)));
    }
}
