const assert = require('assert');

const connectSticks = (sticks) => {
  if (sticks.length === 1) return 0;

  const heap = [0, ...sticks.sort((a, b) => a - b)];
  let cost = 0,
    size = sticks.length;

  const insert = (val) => {
    size++;
    heap[size] = val;
    let ptr = size;
    while (ptr > 1) {
      const parentPtr = Math.floor(ptr / 2);
      const currVal = heap[ptr];
      const parentVal = heap[parentPtr];

      if (currVal >= parentVal) break;

      const tmp = currVal; // swap
      heap[ptr] = parentVal;
      heap[parentPtr] = tmp;
      ptr = parentPtr;
    }
  };

  const pop = () => {
    size--;
    // TODO: implement MinHeap pop
  };

  while (size > 1) insert(pop() + pop());

  return cost;
};

assert.deepEqual(connectSticks([2, 4, 3]), 14);
assert.deepEqual(connectSticks([1, 8, 3, 5]), 30);
assert.deepEqual(connectSticks([5]), 0);

console.log('All test passed');
