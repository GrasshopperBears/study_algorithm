const assert = require('assert');

const threeSum = (nums) => {
  const result = [];
  nums.sort((a, b) => a - b);

  const helper = (idx) => {
    const visited = new Set();
    for (let j = idx + 1; j < nums.length; j++) {
      const target = nums[idx] + nums[j];
      if (visited.has(-target)) {
        result.push([nums[idx], nums[j], -target]);
        while (j < nums.length - 1 && nums[j] === nums[j + 1]) j++;
      }
      visited.add(nums[j]);
    }
  };

  for (let i = 0; i < nums.length && nums[i] <= 0; i++) {
    if (i == 0 || nums[i - 1] !== nums[i]) helper(i);
  }
  return result;
};

assert.deepEqual(threeSum([-1, 0, 1, 2, -1, -4]), [
  [-1, -1, 2],
  [-1, 0, 1],
]);
assert.deepEqual(threeSum([]), []);
assert.deepEqual(threeSum([0]), []);

console.log('All test passed');
