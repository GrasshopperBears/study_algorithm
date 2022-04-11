const assert = require('assert');

const ROOM_SIZE = 5;
const directions = [
  [-1, 0],
  [1, 0],
  [0, -1],
  [0, 1],
];

const getParticipants = (place) => {
  return place.reduce((acc, row, rowIdx) => {
    for (let colIdx = 0; colIdx < ROOM_SIZE; colIdx++) {
      if (row[colIdx] === 'P') acc.push([rowIdx, colIdx]);
    }
    return acc;
  }, []);
};

const checkSocialDistance = (place) => {
  const participants = getParticipants(place);
  let result = 1;

  const visit = (row, col, [fromRow, fromCol], depth) => {
    if (row < 0 || row >= ROOM_SIZE || col < 0 || col >= ROOM_SIZE) return;
    const current = place[row][col];
    if (current === 'X') return;
    if (depth > 0 && depth <= 2 && current === 'P') {
      result = 0;
      return;
    }
    if (depth < 2) {
      directions.map(([rowDir, colDir]) => {
        const nextRow = row + rowDir;
        const nextCol = col + colDir;
        if (!(nextRow === fromRow && nextCol === fromCol)) visit(row + rowDir, col + colDir, [row, col], depth + 1);
      });
    }
  };

  for (let [row, col] of participants) {
    visit(row, col, [0, 0], 0);
    if (!result) break;
  }
  return result;
};

const solution = (places) => {
  return places.reduce((acc, place) => {
    acc.push(checkSocialDistance(place));
    return acc;
  }, []);
};

assert.deepEqual(
  solution([
    ['POOOP', 'OXXOX', 'OPXPX', 'OOXOX', 'POXXP'],
    ['POOPX', 'OXPXP', 'PXXXO', 'OXXXO', 'OOOPP'],
    ['PXOPX', 'OXOXP', 'OXPXX', 'OXXXP', 'POOXX'],
    ['OOOXX', 'XOOOX', 'OOOXX', 'OXOOX', 'OOOOO'],
    ['PXPXP', 'XPXPX', 'PXPXP', 'XPXPX', 'PXPXP'],
  ]),
  [1, 0, 1, 1, 1]
);

console.log('All test passed');
