import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2525 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int hh = Integer.parseInt(tokens[0]), mm = Integer.parseInt(tokens[1]);
        int duration = Integer.parseInt(br.readLine());

        mm += duration % 60;
        hh += duration / 60 + mm / 60;

        System.out.printf("%d %d", hh % 24, mm % 60);
    }
}
