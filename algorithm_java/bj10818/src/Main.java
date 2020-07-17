import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int tmp;

        for (int i = 0; i < num; i++) {
            if (max < (tmp = Integer.parseInt(st.nextToken()))) {
                max = tmp;
            }
            if (tmp < min) {
                min = tmp;
            }
        }

        System.out.println(Integer.toString(min) + " " + Integer.toString(max));
    }
}
