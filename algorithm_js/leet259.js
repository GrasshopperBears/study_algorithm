const assert = require('assert');

const threeSumSmaller = (nums, target) => {
  let result = 0;
  nums.sort((a, b) => a - b);

  for (let left = 0; left < nums.length - 2; left++) {
    const leftNum = nums[left];
    let mid = left + 1,
      right = nums.length - 1;
    while (mid < right) {
      if (leftNum + nums[mid] + nums[right] < target) {
        result += right - mid;
        mid++;
      } else right--;
    }
  }
  return result;
};

assert.deepEqual(threeSumSmaller([-3, -1, -4, -4, 0, 2, -2], -8), 5);
assert.deepEqual(threeSumSmaller([-2, 0, 3, 1], 2), 2);
assert.deepEqual(threeSumSmaller([], 0), 0);
assert.deepEqual(threeSumSmaller([0], 0), 0);
assert.deepEqual(threeSumSmaller([-1, 0, 1, 0], 0), 1);

console.log('All test passed');
