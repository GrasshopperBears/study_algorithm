const assert = require('assert');

// const countMaxOrSubsets = (nums: number[]): number => {
//   const maxOr = nums.reduce((acc, num) => acc | num, 0);
//   const candidates: number[][] = [];

//   let mask = 1;
//   while (mask <= maxOr) {
//     candidates.push([]);
//     mask *= 2;
//   }

//   for (let i = 0; i < nums.length; i++) {
//     const current = nums[i];
//     mask = 1;
//     let bitPos = 0;
//     while (mask <= current) {
//       if (current & mask) candidates[bitPos].push(current);
//       mask *= 2;
//       bitPos++;
//     }
//   }
// };

const countMaxOrSubsets = (nums: number[]): number => {
  const maxOr = nums.reduce((acc, num) => acc | num, 0);
  const length = nums.length;
  let answer = 0;

  for (let i = 1; i < 1 << length; i++) {
    let current = 0;
    for (let j = 0; j < length; j++) if ((i >> j) & 1) current |= nums[j];
    if (current === maxOr) answer++;
  }

  return answer;
};

assert.deepEqual(countMaxOrSubsets([3, 1]), 2);
assert.deepEqual(countMaxOrSubsets([2, 2, 2]), 7);
assert.deepEqual(countMaxOrSubsets([3, 2, 1, 5]), 6);

console.log('All test passed');
