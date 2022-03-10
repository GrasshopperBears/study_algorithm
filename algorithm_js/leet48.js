const assert = require('assert');

const rotate = (matrix) => {
  let lty, ltx, rty, rtx, rby, rbx, lby, lbx;
  const half = parseInt(matrix.length / 2);
  const len = matrix.length;

  for (let i = 0; i < half; i++) {
    if (i === len - 1 - i) return;

    lty = ltx = rty = lbx = i;
    rtx = lby = rbx = rby = len - 1 - i;

    while (rbx > i) {
      const tmp = matrix[lty][ltx];
      matrix[lty][ltx] = matrix[lby][lbx];
      matrix[lby][lbx] = matrix[rby][rbx];
      matrix[rby][rbx] = matrix[rty][rtx];
      matrix[rty][rtx] = tmp;
      ltx++;
      rty++;
      rbx--;
      lby--;
    }
  }
};

let matrix;

matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9],
];
rotate(matrix);
assert.deepEqual(matrix, [
  [7, 4, 1],
  [8, 5, 2],
  [9, 6, 3],
]);

matrix = [
  [5, 1, 9, 11],
  [2, 4, 8, 10],
  [13, 3, 6, 7],
  [15, 14, 12, 16],
];
rotate(matrix);
assert.deepEqual(matrix, [
  [15, 13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7, 10, 11],
]);

console.log('All test passed');
