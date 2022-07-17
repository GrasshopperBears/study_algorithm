import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj2675 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] tmp = br.readLine().trim().split(" ");
            int num = Integer.parseInt(tmp[0]);
            String answer = "";

            for (int j = 0; j < tmp[1].length(); j++) {
                answer += new String(new char[num]).replace("\0", tmp[1].substring(j, j + 1));
            }

            System.out.println(answer);
        }
    }
}
