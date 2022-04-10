const assert = require('assert');

class TicTacToe {
  constructor(n) {
    this.size = n;
    this.rowSum = new Array(n).fill(0);
    this.colSum = new Array(n).fill(0);
    this.diagSum = new Array(2).fill(0);
  }

  move(row, col, player) {
    const playerToNum = player === 1 ? 1 : -1;

    this.rowSum[row] += playerToNum;
    this.colSum[col] += playerToNum;

    if (this.rowSum[row] === this.size * playerToNum) return player;
    if (this.colSum[col] === this.size * playerToNum) return player;

    if (row + col === this.size - 1) {
      this.diagSum[0] += playerToNum;
      if (this.diagSum[0] === this.size * playerToNum) return player;
    }
    if (row === col) {
      this.diagSum[1] += playerToNum;
      if (this.diagSum[1] === this.size * playerToNum) return player;
    }

    return 0;
  }
}

const board1 = new TicTacToe(3);
assert.deepEqual(board1.move(0, 0, 1), 0);
assert.deepEqual(board1.move(0, 2, 2), 0);
assert.deepEqual(board1.move(2, 2, 1), 0);
assert.deepEqual(board1.move(1, 1, 2), 0);
assert.deepEqual(board1.move(2, 0, 1), 0);
assert.deepEqual(board1.move(1, 0, 2), 0);
assert.deepEqual(board1.move(2, 1, 1), 1);

const board2 = new TicTacToe(2);
assert.deepEqual(board2.move(0, 0, 2), 0);
assert.deepEqual(board2.move(1, 1, 1), 0);
assert.deepEqual(board2.move(0, 1, 2), 2);

console.log('All test passed');
