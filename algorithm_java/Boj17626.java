import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj17626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), bound = (int) Math.floor(Math.sqrt(n));
        ArrayList<Integer> squares = new ArrayList<>();

        for (int i = 0; i <= bound; i++)
            squares.add(i * i);

        for (int i = 0; i < squares.size(); i++) {
            int a = squares.get(i);
            for (int j = i; j < squares.size(); j++) {
                int b = squares.get(j);
                for (int k = j; k < squares.size(); k++) {
                    int c = squares.get(k);
                    for (int l = k; l < squares.size(); l++) {
                        int d = squares.get(l);
                        if (a + b + c + d == n) {
                            int answer = 0;
                            if (a != 0)
                                answer++;
                            if (b != 0)
                                answer++;
                            if (c != 0)
                                answer++;
                            if (d != 0)
                                answer++;
                            System.out.println(answer);
                            return;
                        }
                    }
                }
            }
        }
    }
}
