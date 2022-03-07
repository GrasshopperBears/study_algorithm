const assert = require('assert');

const buildArray = (nums) => {
  const ans = new Array(nums.length);
  for (let i = 0; i < nums.length; i++) {
    ans[i] = nums[nums[i]];
  }
  return ans;
};

assert.deepEqual(buildArray([0, 2, 1, 5, 3, 4]), [0, 1, 2, 4, 5, 3]);
assert.deepEqual(buildArray([5, 0, 1, 2, 3, 4]), [4, 5, 0, 1, 2, 3]);

console.log('All test passed');
