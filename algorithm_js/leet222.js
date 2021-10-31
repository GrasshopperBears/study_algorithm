const assert = require('assert');
const { TreeNode } = require('./lib/TreeNode');

const countNodes = (root) => {
  if (!root || root.val === undefined) return 0;
  if (!root.left && !root.right) return 1;
  return countNodes(root.left) + countNodes(root.right) + 1;
};

assert.deepEqual(countNodes(new TreeNode(1)), 1);

const testTree = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6)));
assert.deepEqual(countNodes(testTree), 6);

console.log('All test passed');
