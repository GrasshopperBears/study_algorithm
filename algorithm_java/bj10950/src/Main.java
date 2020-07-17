import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a, b;
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            String tmp = br.readLine();
            String[] nums = tmp.split(" ");
            a = Integer.parseInt(nums[0]);
            b = Integer.parseInt(nums[1]);

            bw.write(Integer.toString(a + b));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}