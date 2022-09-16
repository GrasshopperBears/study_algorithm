import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class DslrHistory {
    DslrHistory prev = null;
    char c;
    int num;

    public DslrHistory(DslrHistory prev, char c, int num) {
        this.prev = prev;
        this.c = c;
        this.num = num;
    }
}

public class Boj9019 {
    private static String getResult(DslrHistory x) {
        StringBuilder result = new StringBuilder();
        while (x.prev != null) {
            result.append(x.c);
            x = x.prev;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        for (int t = 0; t < tc; t++) {
            String[] tokens = br.readLine().split(" ");
            int from = Integer.parseInt(tokens[0]), to = Integer.parseInt(tokens[1]);
            Queue<DslrHistory> q = new LinkedList<>();
            q.add(new DslrHistory(null, (char) 0, from));
            boolean[] visited = new boolean[10000];

            while (q.size() > 0) {
                DslrHistory first = q.poll();
                if (first.num == to) {
                    answer.append(getResult(first)).append('\n');
                    break;
                }
                if (visited[first.num])
                    continue;
                visited[first.num] = true;

                DslrHistory d = new DslrHistory(first, 'D', (first.num * 2) % 10000);
                DslrHistory s = new DslrHistory(first, 'S', first.num - 1);
                if (s.num < 0)
                    s.num = 9999;
                DslrHistory l = new DslrHistory(first, 'L', (first.num % 1000) * 10 + first.num / 1000);
                DslrHistory r = new DslrHistory(first, 'R', first.num / 10 + (first.num % 10) * 1000);

                q.add(d);
                q.add(s);
                q.add(l);
                q.add(r);
            }
        }
        System.out.println(answer.toString());
    }
}
