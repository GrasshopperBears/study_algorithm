const assert = require('assert');

const getPossibleSumSet = (arr, idx, sum, set) => {
  if (idx === arr.length) {
    set.add(sum);
    return;
  }

  const current = arr[idx];
  getPossibleSumSet(arr, idx + 1, sum + current, set);
  getPossibleSumSet(arr, idx + 1, sum, set);
};

const minAbsDifference = (nums, goal) => {
  const mid = Math.floor(nums.length / 2);
  const leftSet = new Set();
  const rightSet = new Set();
  let answer = -1;

  // Due to this dividing, complexity becomes O(n*2^(n/2))
  getPossibleSumSet(nums.slice(0, mid), 0, 0, leftSet);
  getPossibleSumSet(nums.slice(mid), 0, 0, rightSet);

  const rightSortedSum = [...rightSet];
  rightSortedSum.sort((a, b) => a - b);

  for (let leftSum of leftSet) {
    let left = 0,
      right = rightSortedSum.length - 1;
    const remain = goal - leftSum;

    if (remain < rightSortedSum[0]) {
      const diff = Math.abs(remain - rightSortedSum[0]);
      if (answer < 0) answer = diff;
      else if (answer > diff) answer = diff;
      continue;
    }
    if (remain > rightSortedSum[rightSortedSum.length - 1]) {
      const diff = Math.abs(remain - rightSortedSum[rightSortedSum.length - 1]);
      if (answer < 0) answer = diff;
      else if (answer > diff) answer = diff;
      continue;
    }

    let mid;

    // binary search of remain
    while (left <= right) {
      mid = Math.floor((left + right) / 2);

      if (rightSortedSum[mid] > remain) right = mid - 1;
      else if (rightSortedSum[mid] < remain) left = mid + 1;
      else break;
    }

    const currentDiff = Math.abs(leftSum + rightSortedSum[mid] - goal);
    if (mid >= 0 && (answer < 0 || answer > currentDiff)) answer = currentDiff;
    if (mid < rightSortedSum.length - 1) {
      const adjDiff = Math.abs(rightSortedSum[mid + 1] + leftSum - goal);
      if (answer > adjDiff) answer = adjDiff;
    }
    if (mid > 0) {
      const adjDiff = Math.abs(rightSortedSum[mid - 1] + leftSum - goal);
      if (answer > adjDiff) answer = adjDiff;
    }
    if (answer === 0) break;
  }
  return answer;
};

assert.deepEqual(minAbsDifference([5, -7, 3, 5], 6), 0);
assert.deepEqual(minAbsDifference([7, -9, 15, -2], -5), 1);
assert.deepEqual(minAbsDifference([1, 2, 3], -7), 7);
assert.deepEqual(minAbsDifference([2886, 2141, 6046, -9031, 5378, -8576, 109], -512655773), 512638166);
assert.deepEqual(minAbsDifference([8106556, 8399185, -2209462, 3571253, 7239316, 1536882], 100585228), 71732036);
assert.deepEqual(
  minAbsDifference([1556913, -259675, -7667451, -4380629, -4643857, -1436369, 7695949, -4357992, -842512, -118463], -9681425),
  10327
);
assert.deepEqual(minAbsDifference([-4816, 3637, 8511, -1731, -5728, -9723, 8373, -8758], 12826), 236);
assert.deepEqual(minAbsDifference([1641068, -6677261, -3095782, 9239530, 4527395, 9844403, -3486460, 6520549, -6496105], 5564136), 32222);
assert.deepEqual(minAbsDifference([-9316362, -1820796, 3481286, -7573091, -1005271, 8495362, -7620442], -14331141), 22902);
assert.deepEqual(minAbsDifference([0, -8, -14, 7, -21, 21, -7, 5, 13, -6, 30, 30], -54), 2);

console.log('All test passed');
