import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Boj1477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), m = Integer.parseInt(tokens[1]), l = Integer.parseInt(tokens[2]);
        int[] positions = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        tokens = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            positions[i] = Integer.parseInt(tokens[i]);
        Arrays.sort(positions);

        int prev = 0;
        for (int i = 0; i < n; i++) {
            pq.add(prev - positions[i]);
            prev = positions[i];
        }
        pq.add(prev - l);

        for (int ii = 0; ii < m; ii++) {
            int biggest = pq.poll();
            int part = biggest / 2;
            pq.add(part);
            pq.add(biggest - part);
        }

        System.out.println(-pq.poll());
    }
}
