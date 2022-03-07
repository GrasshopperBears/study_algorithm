const printLinkedListInReverse = (head) => {
  const stack = [];

  while (head) {
    stack.push(head);
    head = head.getNext();
  }

  for (let i = stack.length - 1; i >= 0; i--) {
    stack[i].printValue();
  }
};
