import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11022 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int casenum = Integer.parseInt(br.readLine());
        String[] tmp;

        for (int i = 0; i < casenum; i++) {
            tmp = br.readLine().split(" ");

            System.out.printf("Case #%d: %s + %s = %d\n", i + 1, tmp[0], tmp[1], Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[1]));
        }
    }
}
