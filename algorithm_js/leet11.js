const assert = require('assert');

const maxArea = (heights) => {
  let left = 0,
    right = heights.length - 1,
    max = 0;

  while (left < right) {
    const currentHeight = Math.min(heights[left], heights[right]);
    max = Math.max(max, currentHeight * (right - left));
    if (heights[right] > heights[left]) left++;
    else right--;
  }
  return max;
};

assert.deepEqual(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]), 49);
assert.deepEqual(maxArea([1, 1]), 1);
assert.deepEqual(maxArea([1, 8, 6, 2, 5, 4, 8, 25, 7]), 49);

console.log('All test passed');
