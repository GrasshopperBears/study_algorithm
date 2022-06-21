const largestBSTSubtree = (root) => {
  let max = 0;
  const visit = (node) => {
    if (!node) return [null, null, 0];

    let leftMin = null,
      leftMax = null,
      leftCount = 0;
    if (node.left) {
      [leftMin, leftMax, leftCount] = visit(node.left);
    } else {
      leftMin = node.val;
      leftMax = node.val;
    }

    let rightMin = null,
      rightMax = null,
      rightCount = 0;
    if (node.right) {
      [rightMin, rightMax, rightCount] = visit(node.right);
    } else {
      rightMin = node.val;
      rightMax = node.val;
    }

    if (node.left && (leftCount === 0 || leftMax >= node.val)) return [null, null, 0];
    if (node.right && (rightCount === 0 || rightMin <= node.val)) return [null, null, 0];

    const currentMax = leftCount + rightCount + 1;
    max = Math.max(max, currentMax);
    return [leftMin, rightMax, currentMax];
  };

  visit(root);

  return max;
};
