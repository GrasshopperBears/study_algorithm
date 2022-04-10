const assert = require('assert');

const LANES = 3;

const minSideJumps = (obstacles) => {
  const n = obstacles.length;

  if (n < 3) return 0;

  const dp = new Array(LANES).fill(0).reduce((acc) => {
    acc.push(new Array(n).fill(0));
    return acc;
  }, []);

  for (let i = n - 2; i >= 0; i--) {
    const currentObstacle = obstacles[i] - 1;
    for (let lane = 0; lane < LANES; lane++) {
      if (currentObstacle === lane) {
        dp[lane][i] = -1;
        continue;
      }
      const candidates = [];
      const next = (lane + 1) % LANES;
      const nextNext = (lane + 2) % LANES;
      if (dp[lane][i + 1] >= 0) candidates.push(dp[lane][i + 1]);
      if (currentObstacle !== next && dp[next][i + 1] >= 0) candidates.push(dp[next][i + 1] + 1);
      if (currentObstacle !== nextNext && dp[nextNext][i + 1] >= 0) candidates.push(dp[nextNext][i + 1] + 1);
      dp[lane][i] = Math.min(...candidates);
    }
  }
  return dp[1][0];
};

[
  [1, -1, 0, 0, 0],
  [0, 2, -1, 0, 0],
  [0, 0, 1, -1, 0],
];

assert.deepEqual(minSideJumps([0, 1, 2, 3, 0]), 2);
assert.deepEqual(minSideJumps([0, 1, 1, 3, 3, 0]), 0);
assert.deepEqual(minSideJumps([0, 2, 1, 0, 3, 0]), 2);

console.log('All test passed');
