import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node {
    int val;
    Node prev, next;

    public Node(int val) {
        this.val = val;
    }
}

public class Boj11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]), k = Integer.parseInt(tokens[1]);
        Node node = new Node(1), prev = node;

        for (int i = 2; i <= n; i++) {
            prev.next = new Node(i);
            prev.next.prev = prev;
            prev = prev.next;
        }
        prev.next = node;
        node.prev = prev;

        StringBuilder answer = new StringBuilder();
        answer.append("<");
        for (int i = 0; i < k - 1; i++)
            node = node.next;

        while (true) {
            if (node.next == node) {
                answer.append(node.val);
                break;
            }
            answer.append(node.val).append(", ");
            node.next.prev = node.prev;
            node.prev.next = node.next;
            for (int i = 0; i < k; i++)
                node = node.next;
        }
        answer.append(">");
        System.out.println(answer.toString());
    }
}
