const assert = require('assert');

const minDistance = (height, width, tree, squirrel, nuts) => {
  const [treeR, treeC] = tree;
  const [squirrelR, squirrelC] = squirrel;

  let nutTreeDistanceSum = 0;
  let maxReduction =
    Math.abs(nuts[0][0] - treeR) + Math.abs(nuts[0][1] - treeC) - (Math.abs(nuts[0][0] - squirrelR) + Math.abs(nuts[0][1] - squirrelC));

  for (let [nutR, nutC] of nuts) {
    const nutTreeDistance = Math.abs(nutR - treeR) + Math.abs(nutC - treeC);
    nutTreeDistanceSum += 2 * nutTreeDistance;
    maxReduction = Math.max(maxReduction, nutTreeDistance - (Math.abs(nutR - squirrelR) + Math.abs(nutC - squirrelC)));
  }

  return nutTreeDistanceSum - maxReduction;
};

assert.deepEqual(
  minDistance(
    5,
    7,
    [2, 2],
    [4, 4],
    [
      [3, 0],
      [2, 5],
    ]
  ),
  12
);
assert.deepEqual(minDistance(1, 3, [0, 1], [0, 0], [[0, 2]]), 3);

console.log('All test passed');
