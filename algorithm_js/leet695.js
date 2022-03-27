const assert = require('assert');

const maxAreaOfIsland = (grid) => {
  const rows = grid.length;
  const cols = grid[0].length;
  const visited = new Array(rows).fill(0).reduce((acc) => {
    acc.push(new Array(cols).fill(false));
    return acc;
  }, []);
  let maxArea = 0;

  const dfs = (row, col) => {
    if (visited[row][col]) return 0;
    let current = 1;
    visited[row][col] = true;
    if (row > 0 && grid[row - 1][col]) current += dfs(row - 1, col);
    if (col > 0 && grid[row][col - 1]) current += dfs(row, col - 1);
    if (row < rows - 1 && grid[row + 1][col]) current += dfs(row + 1, col);
    if (col < cols - 1 && grid[row][col + 1]) current += dfs(row, col + 1);

    maxArea = Math.max(maxArea, current);
    return current;
  };

  for (let row = 0; row < rows; row++) {
    for (let col = 0; col < cols; col++) {
      if (grid[row][col]) dfs(row, col);
    }
  }
  return maxArea;
};

assert.deepEqual(
  maxAreaOfIsland([
    [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
    [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
    [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
    [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
  ]),
  6
);
assert.deepEqual(maxAreaOfIsland([[0, 0, 0, 0, 0, 0, 0, 0]]), 0);

console.log('All test passed');
