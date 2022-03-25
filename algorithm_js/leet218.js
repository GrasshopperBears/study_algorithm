const assert = require('assert');

const merge = (left, right) => {
  let i = 0,
    j = 0,
    result = [],
    currX = 0,
    currY = 0,
    leftY = 0,
    rightY = 0,
    maxY = 0;

  while (i < left.length || j < right.length) {
    if (i === left.length) {
      currX = right[j][0];
      rightY = right[j++][1];
    } else if (j === right.length) {
      currX = left[i][0];
      leftY = left[i++][1];
    } else {
      if (left[i][0] < right[j][0]) {
        currX = left[i][0];
        leftY = left[i++][1];
      } else if (left[i][0] > right[j][0]) {
        currX = right[j][0];
        rightY = right[j++][1];
      } else {
        currX = left[i][0];
        leftY = left[i++][1];
        rightY = right[j++][1];
      }
    }
    maxY = Math.max(leftY, rightY);

    if (maxY !== currY) {
      currY = maxY;
      result.push([currX, currY]);
    }
  }
  return result;
};

const helper = (buildings) => {
  if (!buildings.length) return [];
  if (buildings.length === 1)
    return [
      [buildings[0][0], buildings[0][2]],
      [buildings[0][1], 0],
    ];

  const mid = Math.floor(buildings.length / 2);
  const left = helper(buildings.slice(0, mid));
  const right = helper(buildings.slice(mid));

  return merge(left, right);
};

const getSkyline = (buildings) => {
  return helper(buildings);
};

assert.deepEqual(
  getSkyline([
    [2, 9, 10],
    [3, 7, 15],
    [5, 12, 12],
    [15, 20, 10],
    [19, 24, 8],
  ]),
  [
    [2, 10],
    [3, 15],
    [7, 12],
    [12, 0],
    [15, 10],
    [20, 8],
    [24, 0],
  ]
);
assert.deepEqual(
  getSkyline([
    [0, 2, 3],
    [2, 5, 3],
  ]),
  [
    [0, 3],
    [5, 0],
  ]
);

console.log('All test passed');
