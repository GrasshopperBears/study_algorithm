const assert = require('assert');

const setZeroes = (matrix) => {
  let isFirstColumnZero = false;

  for (let i = 0; i < matrix.length; i++) {
    if (!matrix[i][0]) isFirstColumnZero = true;
    for (let j = 1; j < matrix[0].length; j++) {
      if (!matrix[i][j]) {
        matrix[i][0] = 0;
        matrix[0][j] = 0;
      }
    }
  }
  for (let i = 1; i < matrix.length; i++) {
    for (let j = 1; j < matrix[0].length; j++) {
      if (!matrix[i][0] || !matrix[0][j]) matrix[i][j] = 0;
    }
  }
  if (!matrix[0][0]) {
    for (let i = 0; i < matrix[0].length; i++) {
      matrix[0][i] = 0;
    }
  }
  if (isFirstColumnZero) {
    for (let i = 0; i < matrix.length; i++) {
      matrix[i][0] = 0;
    }
  }
};

const example1 = [
  [1, 1, 1],
  [1, 0, 1],
  [1, 1, 1],
];
setZeroes(example1);
assert.deepEqual(example1, [
  [1, 0, 1],
  [0, 0, 0],
  [1, 0, 1],
]);

const example2 = [
  [0, 1, 2, 0],
  [3, 4, 5, 2],
  [1, 3, 1, 5],
];
setZeroes(example2);
assert.deepEqual(example2, [
  [0, 0, 0, 0],
  [0, 4, 5, 0],
  [0, 3, 1, 0],
]);

console.log('All test passed');
