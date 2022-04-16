const assert = require('assert');
const { TreeNode } = require('./lib/TreeNode');

const sumNumbers = (root) => {
  let sum = 0;

  const visit = (node) => {
    if (!node.left && !node.right) {
      sum += node.val;
      return [1];
    }
    const digits = [];

    if (node.left) {
      for (let digit of visit(node.left)) {
        sum += node.val * Math.pow(10, digit);
        digits.push(digit + 1);
      }
    }
    if (node.right) {
      for (let digit of visit(node.right)) {
        sum += node.val * Math.pow(10, digit);
        digits.push(digit + 1);
      }
    }
    return digits;
  };
  visit(root);
  return sum;
};

const head1 = new TreeNode(1);
head1.left = new TreeNode(2);
head1.right = new TreeNode(3);
assert.deepEqual(sumNumbers(head1), 25);

const head2 = new TreeNode(4);
head2.left = new TreeNode(9);
head2.right = new TreeNode(0);
head2.left.left = new TreeNode(5);
head2.left.right = new TreeNode(1);
assert.deepEqual(sumNumbers(head2), 1026);

console.log('All test passed');
