const assert = require("assert");

const maximumDifference = (nums) => {
  let currentMax = 0;
  let globalMax = 0;

  for (let i = 1; i < nums.length; i++) {
    const diff = nums[i] - nums[i - 1];
    currentMax += diff;
    if (currentMax < 0) {
      currentMax = 0;
    } else if (currentMax > globalMax) {
      globalMax = currentMax;
    }
  }

  return globalMax > 0 ? globalMax : -1;
};

assert.deepEqual(maximumDifference([7, 1, 5, 4]), 4);
assert.deepEqual(maximumDifference([9, 4, 3, 2]), -1);
assert.deepEqual(maximumDifference([1, 5, 2, 10]), 9);

console.log("All test passed");
