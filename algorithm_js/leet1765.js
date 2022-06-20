const assert = require('assert');

const highestPeak = (isWater) => {
  const dirs = [
    [0, 1],
    [0, -1],
    [-1, 0],
    [1, 0],
  ];
  const rows = isWater.length;
  const cols = isWater[0].length;
  const queue = [];

  for (let i = 0; i < rows; i++) {
    for (let j = 0; j < cols; j++) {
      if (isWater[i][j]) queue.push([i, j]);
    }
  }

  const getNext = (row, col) =>
    dirs
      .map(([dirR, dirC]) => [row + dirR, col + dirC])
      .filter(([nextRow, nextCol]) => nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && !isWater[nextRow][nextCol]);

  const ans = Array(rows)
    .fill(0)
    .map(() => Array(cols).fill(0));

  let idx = 0;

  while (idx < queue.length) {
    const [row, col] = queue[idx++];
    const nextHeight = ans[row][col] + 1;
    const result = getNext(row, col);
    result
      .filter(([nextRow, nextCol]) => !ans[nextRow][nextCol])
      .forEach((next) => {
        ans[next[0]][next[1]] = nextHeight;
        queue.push(next);
      });
  }

  return ans;
};

assert.deepEqual(
  highestPeak([
    [0, 1],
    [0, 0],
  ]),
  [
    [1, 0],
    [2, 1],
  ]
);

assert.deepEqual(
  highestPeak([
    [0, 0, 1],
    [1, 0, 0],
    [0, 0, 0],
  ]),
  [
    [1, 1, 0],
    [0, 1, 1],
    [1, 2, 2],
  ]
);

console.log('All test passed');
