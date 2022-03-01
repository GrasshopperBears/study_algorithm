const assert = require('assert');

const threeSumClosest = (nums: number[], target: number) => {
  nums.sort((a, b) => a - b);

  let closest = nums[0] + nums[1] + nums[2];

  for (let i = 0; i < nums.length - 2; i++) {
    let j = i + 1,
      k = nums.length - 1;

    while (j < k) {
      const current = nums[i] + nums[j] + nums[k];
      if (Math.abs(current - target) < Math.abs(closest - target)) closest = current;
      if (closest === target) return closest;

      if (current > target) k--;
      else j++;
    }
  }
  return closest;
};

assert.deepEqual(threeSumClosest([-1, 2, 1, -4], 1), 2);
assert.deepEqual(threeSumClosest([0, 0, 0], 1), 0);
assert.deepEqual(threeSumClosest([1, 1, 1, 0], -100), 2);
assert.deepEqual(threeSumClosest([-4, -1, 1, 2], 1), 2);
assert.deepEqual(threeSumClosest([1, 2, 4, 8, 16, 32, 64, 128], 82), 82);

console.log('All test passed');
