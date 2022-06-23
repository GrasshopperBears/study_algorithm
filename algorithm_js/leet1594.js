const assert = require('assert');

const maxProductPath = (grid) => {
  const MODULO = Math.pow(10, 9) + 7;
  const rows = gird.length;
  const cols = grid[0].length;
  const dp = Array(rows)
    .fill(0)
    .map(() => Array(cols).fill([0, 0]));

  dp[0][0][grid[0][0] > 0 ? 1 : 0] = grid[0][0];
  for (let i = 0; i < rows; i++) {
    for (let j = i === 0 ? 1 : 0; j < cols; j++) {
      const current = grid[i][j];
      if (i > 0) {
        const up = dp[i - 1][j];
      }
      if (j > 0) {
        const left = dp[i][j - 1];
      }
    }
  }

  const last = grid[rows - 1][cols - 1];
  return !last[0] && !last[1] ? 0 : last[1] > 0 ? last[1] : -1;
};

assert.deepEqual(
  maxProductPath([
    [-1, -2, -3],
    [-2, -3, -3],
    [-3, -3, -2],
  ]),
  -1
);
assert.deepEqual(
  maxProductPath([
    [1, -2, 1],
    [1, -2, 1],
    [3, -4, 1],
  ]),
  8
);
assert.deepEqual(
  maxProductPath([
    [1, 3],
    [0, -4],
  ]),
  0
);

console.log('All test passed');
