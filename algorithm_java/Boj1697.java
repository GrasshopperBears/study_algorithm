import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj1697 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int from = Integer.parseInt(tokens[0]), to = Integer.parseInt(tokens[1]);
        boolean[] visited = new boolean[100001];

        if (from >= to) {
            System.out.println(from - to);
            return;
        }

        int time = 0, possibleMin = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        q.add(-1);
        visited[from] = true;

        while (q.size() > 0) {
            int current = q.poll(), nextDouble = current << 1;
            if (current == to)
                break;
            if (current < 0) {
                time++;
                q.add(-1);
                continue;
            }
            if (current < 100000 && !visited[current + 1]) {
                visited[current + 1] = true;
                q.add(current + 1);
            }
            if (current <= 50000 && !visited[nextDouble]) {
                if (nextDouble > to) {
                    possibleMin = Math.min(possibleMin, time + 1 + nextDouble - to);
                } else {
                    visited[nextDouble] = true;
                    q.add(nextDouble);
                }
            }
            if (current > 0 && !visited[current - 1]) {
                visited[current - 1] = true;
                q.add(current - 1);
            }
        }
        System.out.println(Math.min(time, possibleMin));
    }
}
