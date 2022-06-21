const { TreeNode } = require('./lib/TreeNode');

const zigzagLevelOrder = (root) => {
  const result = [];
  if (!root) return result;

  const queue = [root, null];
  let idx = 0,
    dir = 1;

  while (queue.length > idx && queue[idx]) {
    const current = [];

    while (queue[idx]) {
      current.push(queue[idx++].val);
    }
    const next = idx-- + 1;

    while (idx >= 0 && queue[idx]) {
      const node = queue[idx--];
      if (dir > 0 && node.right) queue.push(node.right);
      if (node.left) queue.push(node.left);
      if (dir < 0 && node.right) queue.push(node.right);
    }

    result.push(current);
    queue.push(null);
    dir *= -1;
    idx = next;
  }
  return result;
};

const root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
zigzagLevelOrder(root);
