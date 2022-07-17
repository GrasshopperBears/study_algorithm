import leetLibrary.Node;
import java.util.ArrayList;

class Leet559 {
    public int maxDepth(Node root) {
        int answer = 0;
        ArrayList<Node> q = new ArrayList<>();
        q.add(root);
        q.add(null);
        while (true) {
            Node curr = q.remove(0);
            if (curr == null) break;

            answer++;
            while (curr != null) {
                q.addAll(curr.children);
                curr = q.remove(0);
            }
            q.add(null);
        }
        return answer;
    }
}
