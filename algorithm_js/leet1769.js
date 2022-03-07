const assert = require('assert');

const minOperations = (boxes) => {
  const boxSize = boxes.length;
  const answer = new Array(boxSize).fill(0);

  for (let i = 0, currentCount = 0, ops = 0; i < boxSize; i++) {
    answer[i] += ops;
    if (boxes[i] === '1') currentCount++;
    ops += currentCount;
  }
  for (let i = boxSize - 1, currentCount = 0, ops = 0; i >= 0; i--) {
    answer[i] += ops;
    if (boxes[i] === '1') currentCount++;
    ops += currentCount;
  }
  return answer;
};

assert.deepEqual(minOperations('110'), [1, 1, 3]);
assert.deepEqual(minOperations('001011'), [11, 8, 5, 4, 3, 4]);

console.log('All test passed');
