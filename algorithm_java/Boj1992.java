import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1992 {
    private static boolean[][] map;

    private static StringBuilder getTree(int fromR, int fromC, int size) {
        StringBuilder answer = new StringBuilder();
        boolean base = map[fromR][fromC];
        for (int i = fromR; i < fromR + size; i++) {
            for (int j = fromC; j < fromC + size; j++) {
                if (map[i][j] != base) {
                    int half = size / 2;
                    answer.append("(");
                    answer.append(getTree(fromR, fromC, half));
                    answer.append(getTree(fromR, fromC + half, half));
                    answer.append(getTree(fromR + half, fromC, half));
                    answer.append(getTree(fromR + half, fromC + half, half));
                    answer.append(")");
                    return answer;
                }
            }
        }
        answer.append(base ? "1" : "0");
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++)
                map[i][j] = line.charAt(j) == '1';
        }
        System.out.println(getTree(0, 0, n).toString());
    }
}
