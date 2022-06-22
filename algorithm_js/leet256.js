const assert = require('assert');

const minCost = (costs) => {
  const last = costs[costs.length - 1];

  for (let i = costs.length - 2; i >= 0; i--) {
    const current = costs[i];
    current[0] += Math.min(last[1], last[2]);
    current[1] += Math.min(last[0], last[2]);
    current[2] += Math.min(last[0], last[1]);

    for (let j = 0; j < 3; j++) last[j] = current[j];
  }

  return Math.min(...last);
};

assert.deepEqual(
  minCost([
    [17, 2, 17],
    [16, 16, 5],
    [14, 3, 19],
  ]),
  10
);
assert.deepEqual(minCost([[7, 6, 2]]), 2);

console.log('All test passed');
