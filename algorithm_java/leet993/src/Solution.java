import leetLibrary.TreeNode;

class Solution {
    int xDepth = -1, yDepth = -1, targetX, targetY, xParent, yParent;

    private void visit(TreeNode node, int depth, int parent) {
        if (xDepth >= 0 && yDepth >= 0) return;
        if (node.val == targetX) {
            xDepth = depth;
            xParent = parent;
        } else if (node.val == targetY) {
            yDepth = depth;
            yParent = parent;
        }
        if (node.right != null) visit(node.right, depth + 1, node.val);
        if (node.left != null) visit(node.left, depth + 1, node.val);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        targetX = x;
        targetY = y;
        visit(root, 0, 0);
        return xDepth == yDepth && xParent != yParent;
    }
}