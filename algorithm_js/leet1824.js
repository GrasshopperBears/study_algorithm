const assert = require('assert');

const LANES = 3;

const minSideJumps = (obstacles) => {
  const n = obstacles.length;

  if (n < 3) return 0;

  let lastDp = new Array(LANES).fill(0);

  for (let i = n - 2; i >= 0; i--) {
    const currentObstacle = obstacles[i] - 1;
    const newDp = new Array(LANES).fill(0);
    for (let lane = 0; lane < LANES; lane++) {
      if (currentObstacle === lane) {
        newDp[lane] = -1;
        continue;
      }
      const candidates = [];
      const next = (lane + 1) % LANES;
      const nextNext = (lane + 2) % LANES;
      if (lastDp[lane] >= 0) candidates.push(lastDp[lane]);
      if (currentObstacle !== next && lastDp[next] >= 0) candidates.push(lastDp[next] + 1);
      if (currentObstacle !== nextNext && lastDp[nextNext] >= 0) candidates.push(lastDp[nextNext] + 1);
      newDp[lane] = Math.min(...candidates);
    }
    lastDp = newDp;
  }
  return lastDp[1];
};

assert.deepEqual(minSideJumps([0, 1, 2, 3, 0]), 2);
assert.deepEqual(minSideJumps([0, 1, 1, 3, 3, 0]), 0);
assert.deepEqual(minSideJumps([0, 2, 1, 0, 3, 0]), 2);

console.log('All test passed');
