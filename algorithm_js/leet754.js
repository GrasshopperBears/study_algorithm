const assert = require('assert');

const reachNumber = (target) => {
  target = target > 0 ? target : -target;
  let i = 0;
  let current = 0;

  while (current < target) {
    i++;
    current += i;
  }
  return (current - target) % 2 ? i + 1 + (i % 2) : i;
};

assert.deepEqual(reachNumber(2), 3);
assert.deepEqual(reachNumber(3), 2);
assert.deepEqual(reachNumber(5), 5);

console.log('All test passed');
