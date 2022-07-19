import leetLibrary.TreeNode;

class Leet450 {
    private TreeNode[] find(TreeNode parent, TreeNode node, boolean isPre) {
        if (isPre && node.right != null) {
            return find(node, node.right, isPre);
        } else if (!isPre && node.left != null) {
            return find(node, node.left, isPre);
        }
        return new TreeNode[] {parent, node};
    }

    private TreeNode del(TreeNode parent, TreeNode target, boolean isLeft) {
        TreeNode[] found;
        TreeNode foundParent, foundNode;
        
        if (target.left == null && target.right == null) {
            if (parent != null) {
                if (isLeft) parent.left = null;
                else parent.right = null;
            }
            return null;
        }
        if (target.left != null) {
            found = find(target, target.left, true);
        } else {
            found = find(target, target.right, false);
        }
        foundParent = found[0];
        foundNode = found[1];
        isLeft = foundNode == foundParent.left;
        target.val = foundNode.val;

        if (foundParent != null) {
            if (isLeft) foundParent.left = del(foundParent, foundNode, isLeft);
            else foundParent.right = del(foundParent, foundNode, isLeft);
        }
        return target;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode parent = null, target = root;
        boolean isLeft = true;
        while (target != null && target.val != key) {
            parent = target;
            parent = target;
            isLeft = target.val > key;
            target = isLeft ? target.left : target.right;
        }
        if (target == null) return root;
        if (parent != null) {
            if (isLeft) parent.left = del(parent, target, isLeft);
            else parent.right = del(parent, target, isLeft);
            return root;
        }
        return del(parent, target, isLeft);
    }
}
