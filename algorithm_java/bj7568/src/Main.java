import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        int[][] info = new int[caseNum][2];
        String[] line;
        int[][] compare = new int[caseNum][caseNum];

        for (int i = 0; i < caseNum; i++) {
            line = br.readLine().split(" ");
            info[i][0] = Integer.parseInt(line[0]);
            info[i][1] = Integer.parseInt(line[1]);
        }
        br.close();

        for (int i = 0; i < caseNum; i++) {
            for (int j = 0; j < caseNum && j != i; j++) {
                if (compare[i][j] != 0) {
                } else if ((info[i][0] >= info[j][0] && info[i][1] <= info[j][1]) || (info[i][0] <= info[j][0] && info[i][1] >= info[j][1])) {
                    compare[i][j] = -1;
                    compare[j][j] = -1;
                } else if (info[i][0] > info[j][0] && info[i][1] > info[j][1]) {
                    compare[i][j] = 1;
                    compare[j][i] = 2;
                } else {
                    compare[i][j] = 2;
                    compare[j][i] = 1;
                }
            }
        }

        for (int i = 0; i < caseNum; i++) {
            int ranking = 1;
            for (int j = 0; j < caseNum; j++) {
                if (compare[i][j] == 2) {
                    ranking++;
                }
            }
            System.out.print(ranking + " ");
        }
    }
}
