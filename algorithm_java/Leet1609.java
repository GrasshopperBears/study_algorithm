import java.util.ArrayDeque;
import java.util.Deque;
import leetLibrary.TreeNode;

public class Leet1609 {
    public boolean isEvenOddTree(TreeNode root) {
        boolean isEven = true;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while (q.size() > 0) {
            int prev = isEven ? 0 : 1000001;
            Deque<TreeNode> next = new ArrayDeque<>();
            while (q.size() > 0) {
                TreeNode node = q.removeFirst();
                int val = node.val;
                if (isEven && (val % 2 == 0 || val <= prev)) return false;
                if (!isEven && (val % 2 != 0 || val >= prev)) return false;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
                prev = val;
            }
            q = next;
            isEven = !isEven;
        }
        return true;
    }
}
