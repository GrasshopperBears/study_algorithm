const assert = require('assert');

const permute = (nums) => {
  let answer = [[nums[0]]];

  for (let i = 1; i < nums.length; i++) {
    const prevList = answer;
    const nextList = [];
    for (let prev of prevList) {
      for (let j = 0; j <= prev.length; j++) nextList.push([...prev.slice(0, j), nums[i], ...prev.slice(j)]);
    }
    answer = nextList;
  }
  return answer;
};

// 순서는 상관없음
assert.deepEqual(permute([1, 2, 3]), [
  [1, 2, 3],
  [1, 3, 2],
  [2, 1, 3],
  [2, 3, 1],
  [3, 1, 2],
  [3, 2, 1],
]);
assert.deepEqual(permute([0, 1]), [
  [0, 1],
  [1, 0],
]);
assert.deepEqual(permute([1]), [[1]]);

console.log('All test passed');
