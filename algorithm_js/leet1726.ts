const assert = require('assert');

const tupleSameProduct = (nums: number[]): number => {
  const productMap = new Map();
  const numsLength = nums.length;
  let result = 0;

  for (let i = 0; i < numsLength; i++) {
    for (let j = i + 1; j < numsLength; j++) {
      const product = nums[i] * nums[j];

      result += 8 * (productMap.get(product) ?? 0);
      productMap.set(product, (productMap.get(product) ?? 0) + 1);
    }
  }
  return result;
};

assert.deepEqual(tupleSameProduct([2, 3, 4, 6]), 8);
assert.deepEqual(tupleSameProduct([1, 2, 4, 5, 10]), 16);

console.log('All test passed');
