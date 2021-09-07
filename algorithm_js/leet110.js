const getHeight = (root) => {
  if (!root) return 0;
  return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
};

const isBalanced = (root) => {
  if (!root) return true;
  if (!(isBalanced(root.left) && isBalanced(root.right))) return false;
  if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) return true;
  return false;
};
