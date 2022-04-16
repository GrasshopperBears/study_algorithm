const findNearestRightNode = (root, u) => {
  let queue = [];
  queue.push(root);

  while (queue.length) {
    const currentQueue = [];
    for (let i = 0; i < queue.length; i++) {
      const currentNode = queue[i];
      if (currentNode.val === u.val) {
        if (i < queue.length - 1) return queue[i + 1];
        return null;
      }
      if (currentNode.left) currentQueue.push(currentNode.left);
      if (currentNode.right) currentQueue.push(currentNode.right);
    }
    queue = currentQueue;
  }
  return null;
};
