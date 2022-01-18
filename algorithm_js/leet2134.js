const assert = require('assert');

const bitNotOp = (bit) => {
  return bit === 0 ? 1 : 0;
};

const minSwaps = (nums) => {
  const countOne = nums.reduce((acc, curr) => {
    return acc + curr;
  }, 0);
  if (countOne <= 1) return 0;

  const len = nums.length;
  let i = 0;
  let j = 0;
  let currSwap = bitNotOp(nums[0]);
  let minSwap = len;
  while (i < len) {
    if (j - i + 1 < countOne) {
      j++;
      currSwap += bitNotOp(nums[j]);
      continue;
    }
    if (minSwap > currSwap) minSwap = currSwap;
    j++;
    currSwap += bitNotOp(nums[j % len]) - bitNotOp(nums[i]);
    i++;
  }
  return minSwap;
};

assert.deepEqual(minSwaps([0, 1, 0, 1, 1, 0, 0]), 1);
assert.deepEqual(minSwaps([0, 1, 1, 1, 0, 0, 1, 1, 0]), 2);
assert.deepEqual(minSwaps([1, 1, 0, 0, 1]), 0);

console.log('All test passed');
