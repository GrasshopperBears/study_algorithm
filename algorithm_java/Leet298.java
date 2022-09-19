import leetLibrary.TreeNode;

public class Leet298 {
    private int maxConsec = 0;

    private int[] dfs(TreeNode node) {
        int[] result = new int[2];
        if (node == null)
            return result;

        result[0] = node.val;
        result[1] = 1;

        if (node.left != null) {
            int[] leftVisit = dfs(node.left);
            if (node.val == leftVisit[0] - 1) {
                result[1] = Math.max(result[1], leftVisit[1] + 1);
            }
        }
        if (node.right != null) {
            int[] rightVisit = dfs(node.right);
            if (node.val == rightVisit[0] - 1) {
                result[1] = Math.max(result[1], rightVisit[1] + 1);
            }
        }
        maxConsec = Math.max(maxConsec, result[1]);
        return result;
    }

    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return maxConsec;
    }
}
