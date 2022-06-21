const assert = require('assert');

const findDuplicate = (nums) => {
  let low = 0,
    high = nums.length - 1,
    answer = 0;

  while (low <= high) {
    const mid = Math.floor((low + high) / 2);
    const count = nums.reduce((acc, num) => acc + (num <= mid ? 1 : 0), 0);
    if (count <= mid) low = mid + 1;
    else {
      answer = mid;
      high = mid - 1;
    }
  }
  return answer;
};

assert.deepEqual(findDuplicate([1, 3, 4, 2, 2]), 2);
assert.deepEqual(findDuplicate([3, 1, 3, 4, 2]), 3);

console.log('All test passed');
