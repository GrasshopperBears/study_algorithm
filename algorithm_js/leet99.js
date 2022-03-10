const recoverTree = (root) => {
  const nodes = [];

  const visit = (node) => {
    if (!node.left && !node.right) {
      nodes.push(node);
      return;
    }
    if (node.left) visit(node.left);
    nodes.push(node);
    if (node.right) visit(node.right);
  };

  visit(root);

  let i = 0,
    j = nodes.length - 1,
    found = false;

  while (i < j) {
    if (found) {
      if (nodes[i].val > nodes[j].val) break;
      i++;
    } else {
      if (nodes[j].val < nodes[j - 1].val) found = true;
      else j--;
    }
  }

  const tmpVal = nodes[i].val;
  nodes[i].val = nodes[j].val;
  nodes[j].val = tmpVal;
};
