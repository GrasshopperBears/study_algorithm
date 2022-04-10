const assert = require('assert');

const generateMatrix = (n) => {
  const result = new Array(n).fill(0).reduce((acc) => {
    acc.push(new Array(n).fill(0));
    return acc;
  }, []);
  let row = 0,
    col = 0,
    rowDir = 0,
    colDir = 1,
    curr = 1;

  while (true) {
    if (row >= n || col >= n || row < 0 || col < 0 || result[row][col] > 0) break;
    result[row][col] = curr++;
    if (colDir > 0 && (col + 1 === n || result[row][col + 1] > 0)) {
      rowDir = 1;
      colDir = 0;
    } else if (rowDir > 0 && (row + 1 === n || result[row + 1][col] > 0)) {
      rowDir = 0;
      colDir = -1;
    } else if (colDir < 0 && (col === 0 || result[row][col - 1] > 0)) {
      rowDir = -1;
      colDir = 0;
    } else if (rowDir < 0 && (row === 0 || result[row - 1][col] > 0)) {
      rowDir = 0;
      colDir = 1;
    }
    row += rowDir;
    col += colDir;
  }

  return result;
};

assert.deepEqual(generateMatrix(1), [[1]]);
assert.deepEqual(generateMatrix(3), [
  [1, 2, 3],
  [8, 9, 4],
  [7, 6, 5],
]);

console.log('All test passed');
