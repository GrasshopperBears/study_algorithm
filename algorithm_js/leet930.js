const assert = require('assert');

const numSubarraysWithSum = (nums, goal) => {
  let answer = 0;
  const ones = nums.reduce(
    (acc, num, idx) => {
      if (num === 1) acc.push(idx);
      return acc;
    },
    [-1]
  );
  ones.push(nums.length);

  if (!goal) {
    for (let i = 0; i < ones.length - 1; i++) {
      const ctsZero = ones[i + 1] - ones[i] - 1;
      answer += (ctsZero * (ctsZero + 1)) / 2;
    }
  } else {
    for (let i = 1; i < ones.length - goal; i++) {
      answer += (ones[i] - ones[i - 1]) * (ones[i + goal] - ones[i + goal - 1]);
    }
  }

  return answer;
};

assert.deepEqual(numSubarraysWithSum([1, 0, 1, 0, 1], 2), 4);
assert.deepEqual(numSubarraysWithSum([0, 0, 0, 0, 0], 0), 15);

console.log('All test passed');
