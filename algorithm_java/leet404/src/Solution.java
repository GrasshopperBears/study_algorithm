import java.util.ArrayList;
import leetLibrary.TreeNode;


class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        ArrayList<TreeNode> nodeQueue = new ArrayList<>();
        ArrayList<Boolean> directionQueue = new ArrayList<>();
        int answer = 0;

        nodeQueue.add(root);
        directionQueue.add(false);

        while (nodeQueue.size() > 0) {
            TreeNode node = nodeQueue.remove(0);
            boolean isLeft = directionQueue.remove(0);
            if (node.left == null && node.right == null && isLeft) {
                answer += node.val;
            } else {
                if (node.left != null) {
                    nodeQueue.add(node.left);
                    directionQueue.add(true);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    directionQueue.add(false);
                }
            }
        }

        return answer;
    }
}