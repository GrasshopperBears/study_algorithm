const assert = require('assert');

const canVisitAllRooms = (rooms) => {
  const visited = new Array(rooms.length).fill(false);
  const visitable = new Array(rooms.length).fill(false);

  const visit = (roomNumber) => {
    if (visited[roomNumber]) return;

    visited[roomNumber] = true;
    visitable[roomNumber] = true;

    rooms[roomNumber].forEach((key) => {
      visit(key);
    });
  };

  visit(0);
  return visitable.every((room) => room);
};

assert.deepEqual(canVisitAllRooms([[1], [2], [3], []]), true);
assert.deepEqual(canVisitAllRooms([[1, 3], [3, 0, 1], [2], [0]]), false);

console.log('All test passed');
