import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Position implements Comparable<Position> {
    int idx, x;

    public Position(int idx, int x) {
        this.idx = idx;
        this.x = x;
    }

    public int compareTo(Position position) {
        if (this.x < position.x)
            return -1;
        if (this.x > position.x)
            return 1;
        return this.idx < position.idx ? -1 : 1;
    }
}

public class Boj18870 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Position[] positions = new Position[n];
        String[] tokens = br.readLine().split(" ");
        int[] compression = new int[n];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            positions[i] = new Position(i, Integer.parseInt(tokens[i]));
        }
        Arrays.sort(positions);

        int prev = Integer.MIN_VALUE, distinct = -1;
        for (int i = 0; i < n; i++) {
            Position position = positions[i];
            if (position.x != prev) {
                compression[position.idx] = ++distinct;
                prev = position.x;
            } else {
                compression[position.idx] = distinct;
            }
        }

        for (int i = 0; i < n; i++)
            answer.append(compression[i]).append(" ");

        System.out.println(answer.toString());
    }
}
