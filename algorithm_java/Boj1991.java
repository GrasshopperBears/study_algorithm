import java.io.BufferedReader;
import java.io.InputStreamReader;

class Node1191 {
    Node1191 left, right;
    int val;

    public Node1191(int val) {
        this.val = val;
    }
}

public class Boj1991 {
    private static StringBuilder pre = new StringBuilder();
    private static StringBuilder in = new StringBuilder();
    private static StringBuilder post = new StringBuilder();
    private static Node1191[] nodes = new Node1191[26];

    private static void dfs(Node1191 node) {
        if (node == null)
            return;
        char c = (char) (node.val + 'A');
        pre.append(c);
        dfs(node.left);
        in.append(c);
        dfs(node.right);
        post.append(c);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < nodes.length; i++)
            nodes[i] = new Node1191(i);

        for (int i = 0; i < n; i++) {
            String tokens = br.readLine();
            char parentC = tokens.charAt(0), leftC = tokens.charAt(2), rightC = tokens.charAt(4);
            Node1191 parent = parentC == '.' ? null : nodes[parentC - 'A'];
            Node1191 left = leftC == '.' ? null : nodes[leftC - 'A'];
            Node1191 right = rightC == '.' ? null : nodes[rightC - 'A'];

            if (parent != null) {
                parent.left = left;
                parent.right = right;
            }
        }
        dfs(nodes[0]);
        System.out.printf("%s\n%s\n%s", pre.toString(), in.toString(), post.toString());
    }
}
