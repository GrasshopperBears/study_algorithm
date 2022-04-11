const assert = require('assert');

class Node {
  constructor(num) {
    this.val = num;
    this.prev = null;
    this.next = null;
  }
}

const move = (node, rows, isDown) => {
  let curr = node;
  for (let i = 0; i < rows; i++) {
    curr = isDown ? curr.next : curr.prev;
  }
  return curr;
};

const solution = (n, k, cmdList) => {
  const delStack = [];
  let head = new Node(0);
  let curr = head;

  for (let i = 1; i < n; i++) {
    const newNode = new Node(i);
    curr.next = newNode;
    newNode.prev = curr;
    curr = newNode;
  }
  curr = head;
  for (let i = 0; i < k; i++) curr = curr.next;

  for (let cmd of cmdList) {
    const tokens = cmd.split(' ');
    if (tokens.length === 2) {
      const rows = Number(tokens[1]);
      if (tokens[0] === 'D') curr = move(curr, rows, true);
      else curr = move(curr, rows, false);
    } else {
      if (tokens[0] === 'C') {
        if (curr.prev === null) head = curr.next;
        else curr.prev.next = curr.next;

        if (curr.next !== null) curr.next.prev = curr.prev;

        delStack.push(curr);
        const moveResult = move(curr, 1, true);
        curr = moveResult !== null ? moveResult : move(curr, 1, false);
      } else {
        const [last] = delStack.splice(delStack.length - 1, 1);

        if (last.prev === null) head = last;
        else last.prev.next = last;

        if (last.next !== null) last.next.prev = last;
      }
    }
  }
  curr = head;
  let result = '';
  for (let i = 0; i < n; i++) {
    if (curr === null || curr.val !== i) {
      result += 'X';
    } else {
      result += 'O';
      curr = curr.next;
    }
  }
  return result;
};

assert.deepEqual(solution(8, 2, ['D 2', 'C', 'U 3', 'C', 'D 4', 'C', 'U 2', 'Z', 'Z']), 'OOOOXOOO');
assert.deepEqual(solution(8, 2, ['D 2', 'C', 'U 3', 'C', 'D 4', 'C', 'U 2', 'Z', 'Z', 'U 1', 'C']), 'OOXOXOOO');
assert.deepEqual(solution(8, 7, ['C', 'C', 'C', 'C', 'C', 'C', 'C']), 'OXXXXXXX');

console.log('All test passed');
