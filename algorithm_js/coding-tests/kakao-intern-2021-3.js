const assert = require('assert');

class Node {
  constructor(num) {
    this.val = num;
    this.prev = null;
    this.next = null;
    this.deleted = false;
  }
}

const moveDown = (node, rows) => {
  let cnt = 0;
  let curr = node;
  while (cnt < rows) {
    curr = curr.next;
    if (curr === null) break;
    if (!curr.deleted) cnt++;
  }
  return curr;
};

const moveUp = (node, rows) => {
  let cnt = 0;
  let curr = node;
  while (cnt < rows) {
    curr = curr.prev;
    if (curr === null) break;
    if (!curr.deleted) cnt++;
  }
  return curr;
};

const solution = (n, k, cmdList) => {
  const delStack = [];
  const head = new Node(0);
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
      if (tokens[0] === 'D') curr = moveDown(curr, rows);
      else curr = moveUp(curr, rows);
    } else {
      if (tokens[0] === 'C') {
        curr.deleted = true;
        delStack.push(curr);
        curr = moveDown(curr, 1) ?? moveUp(curr, 1);
      } else {
        const [last] = delStack.splice(delStack.length - 1, 1);
        last.deleted = false;
      }
    }
  }
  curr = head;
  let result = '';
  while (curr !== null) {
    result += curr.deleted ? 'X' : 'O';
    curr = curr.next;
  }
  return result;
};

assert.deepEqual(solution(8, 2, ['D 2', 'C', 'U 3', 'C', 'D 4', 'C', 'U 2', 'Z', 'Z']), 'OOOOXOOO');
assert.deepEqual(solution(8, 2, ['D 2', 'C', 'U 3', 'C', 'D 4', 'C', 'U 2', 'Z', 'Z', 'U 1', 'C']), 'OOXOXOOO');

console.log('All test passed');
