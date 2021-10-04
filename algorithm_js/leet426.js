const { TreeNode } = require("./lib/TreeNode");

const helper = (node) => {
  let leftHead = undefined;
  let rightTail = undefined;

  if (node.left) {
    let [head, tail] = helper(node.left);
    if (tail) {
      tail.right = node;
      node.left = tail;
      leftHead = head;
    }
  }
  if (node.right) {
    let [head, tail] = helper(node.right);
    if (head) {
      head.left = node;
      node.right = head;
      rightTail = tail;
    }
  }
  if (!leftHead) leftHead = node;
  if (!rightTail) rightTail = node;

  return [leftHead, rightTail];
};

const treeToDoublyList = (root) => {
  if (!root) return root;
  let [head, tail] = helper(root);
  tail.right = head;
  head.left = tail;
  return head;
};

const head = new TreeNode(6, new TreeNode(5, new TreeNode(4)), new TreeNode(7, undefined, new TreeNode(8)));

const result = treeToDoublyList(head);
console.log(result);
