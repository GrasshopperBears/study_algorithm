const assert = require('assert');

const orangesRotting = (grid) => {
  const visitQueue = [];
  let freshCount = 0;
  let time = -1;
  const directions = [
    [0, -1],
    [-1, 0],
    [0, 1],
    [1, 0],
  ];

  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[0].length; j++) {
      if (grid[i][j] === 2) visitQueue.push([i, j]);
      else if (grid[i][j] === 1) freshCount++;
    }
  }
  visitQueue.push([-1, -1]);

  while (visitQueue.length) {
    const [i, j] = visitQueue.splice(0, 1)[0];
    if (i < 0) {
      time++;
      if (visitQueue.length) visitQueue.push([-1, -1]);
      continue;
    }
    for (let [dx, dy] of directions) {
      const x = j + dx;
      const y = i + dy;
      if (y < 0 || x < 0 || y >= grid.length || x >= grid[0].length) continue;
      if (grid[y][x] === 1) {
        grid[y][x] = 2;
        freshCount--;
        visitQueue.push([y, x]);
      }
    }
  }
  return freshCount ? -1 : time;
};

assert.deepEqual(
  orangesRotting([
    [2, 1, 1],
    [1, 1, 0],
    [0, 1, 1],
  ]),
  4
);
assert.deepEqual(
  orangesRotting([
    [2, 1, 1],
    [0, 1, 1],
    [1, 0, 1],
  ]),
  -1
);
assert.deepEqual(orangesRotting([[0, 2]]), 0);

console.log('All test passed');
