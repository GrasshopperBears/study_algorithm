import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node16953 {
    int count;
    long num;

    public Node16953(int count, long num) {
        this.count = count;
        this.num = num;
    }
}

public class Boj16953 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int from = Integer.parseInt(tokens[0]), to = Integer.parseInt(tokens[1]);
        Queue<Node16953> q = new LinkedList<>();
        q.add(new Node16953(0, from));

        while (q.size() > 0) {
            Node16953 first = q.poll();
            if (first.num > to)
                continue;
            if (first.num == to) {
                System.out.println(first.count + 1);
                return;
            }
            q.add(new Node16953(first.count + 1, first.num << 1));
            q.add(new Node16953(first.count + 1, first.num * 10 + 1));
        }
        System.out.println(-1);
    }
}
