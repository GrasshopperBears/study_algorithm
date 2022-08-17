import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj15829 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine()), r = 31, mod = 1234567891;
        long hash = 0, currR = 1;
        String s = br.readLine();
        for (int i = 0; i < len; i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash += val * currR;
            hash %= mod;
            currR *= r;
            currR %= mod;
        }
        System.out.println(hash);
    }
}
