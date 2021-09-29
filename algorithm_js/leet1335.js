// UNSOLVED
const assert = require("assert");

/**
 * DFS version
 */
let jobs = undefined;

const minDifficultyDfs = (idx, day) => {
  if (day === 1) return Math.max(...jobs.slice(idx));

  let result = Number.MAX_VALUE;
  let todayMax = 0;

  for (let i = idx; i <= jobs.length - day; i++) {
    todayMax = Math.max(todayMax, jobs[i]);
    result = Math.min(result, todayMax + minDifficultyDfs(i + 1, day - 1));
  }
  return result;
};

// const minDifficulty = (jobDifficulty, d) => {
//   if (jobDifficulty.length < d) return -1;

//   jobs = jobDifficulty;
//   return minDifficultyDfs(0, d);
// };

/**
 * Stack version
 */

const minDifficulty = (jobDifficulty, d) => {
  if (jobDifficulty.length < d) return -1;

  let dp1 = new Array(jobDifficulty.length).fill(Number.MAX_VALUE);
  let dp2 = new Array(jobDifficulty.length).fill(0);
  for (let i = 0; i < d; i++) {
    const stack = new Array();
    for (let j = i; j < jobDifficulty.length; j++) {
      dp2[j] = j ? dp1[j - 1] + jobDifficulty[j] : jobDifficulty[j];
      while (stack.length && jobDifficulty[stack[stack.length - 1]] <= jobDifficulty[j]) {
        const k = stack.splice(0, 1)[0];
        dp2[j] = Math.min(dp2[j], dp2[k] - jobDifficulty[k] + jobDifficulty[j]);
      }
      if (stack.length) dp2[j] = Math.min(dp2[j], dp2[stack[stack.length - 1]]);
      stack.splice(0, 0, j);
    }
    [dp1, dp2] = [dp2, dp1];
  }
  return dp1[dp1.length - 1];
};

// assert.deepEqual(minDifficulty([9, 9, 9], 4), -1);

assert.deepEqual(minDifficulty([1, 1], 2), 2);
assert.deepEqual(minDifficulty([1, 1, 1], 3), 3);

assert.deepEqual(minDifficulty([2, 1, 1], 2), 3);
assert.deepEqual(minDifficulty([6, 5, 4, 3, 2, 1], 2), 7);

assert.deepEqual(minDifficulty([7, 1, 7, 1, 7, 1], 3), 15);
assert.deepEqual(minDifficulty([11, 111, 22, 222, 33, 333, 44, 444], 6), 843);

console.log("all test passed!");
