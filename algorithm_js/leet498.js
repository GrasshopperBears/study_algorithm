const assert = require('assert');

const findDiagonalOrder = (mat) => {
  const rows = mat.length;
  const cols = mat[0].length;
  const answer = [];
  let direction = 1,
    row = 0,
    col = 0;

  while (true) {
    answer.push(mat[row][col]);
    if (row === rows - 1 && col === cols - 1) break;

    if (direction > 0 && row === 0) {
      if (col === cols - 1) row++;
      else col++;
      direction *= -1;
    } else if (direction > 0 && col === cols - 1) {
      row++;
      direction *= -1;
    } else if (direction < 0 && col === 0) {
      if (row === rows - 1) col++;
      else row++;
      direction *= -1;
    } else if (direction < 0 && row === rows - 1) {
      col++;
      direction *= -1;
    } else {
      row -= direction;
      col += direction;
    }
  }
  return answer;
};

assert.deepEqual(
  findDiagonalOrder([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
  ]),
  [1, 2, 4, 7, 5, 3, 6, 8, 9]
);
assert.deepEqual(
  findDiagonalOrder([
    [1, 2],
    [3, 4],
  ]),
  [1, 2, 3, 4]
);

console.log('All test passed');
