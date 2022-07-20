import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj11660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]), M = Integer.parseInt(tokens[1]), num, x1, x2, y1, y2;
        int[][] prefixSum = new int[N][N];

        for (int i = 0; i < N; i++) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                num = Integer.parseInt(tokens[j]);
                if (j > 0) num += prefixSum[i][j-1];
                if (i > 0) num += prefixSum[i-1][j];
                if (i > 0 && j > 0) num -= prefixSum[i-1][j-1];
                prefixSum[i][j] = num;
            }
        }
        for (int i = 0; i < M; i++) {
            tokens = br.readLine().split(" ");
            x1 = Integer.parseInt(tokens[0])-1;
            y1 = Integer.parseInt(tokens[1])-1;
            x2 = Integer.parseInt(tokens[2])-1;
            y2 = Integer.parseInt(tokens[3])-1;
            num = prefixSum[x2][y2];
            if (x1 > 0) num -= prefixSum[x1-1][y2];
            if (y1 > 0) num -= prefixSum[x2][y1-1];
            if (x1 > 0 && y1 > 0) num += prefixSum[x1-1][y1-1];
            answer.append(num);
            answer.append("\n");
        }
        
        System.out.println(answer.toString());
    }
}
