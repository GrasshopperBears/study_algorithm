const assert = require("assert");

const findLongestChain = (pairs) => {
  const lcDp = new Array(pairs.length).fill(1);
  pairs.sort((a, b) => a[0] - b[0]);

  for (let i = 0; i < pairs.length; i++) {
    for (let j = 0; j < i; j++) {
      if (pairs[i][0] > pairs[j][1]) {
        lcDp[i] = Math.max(lcDp[i], lcDp[j] + 1);
      }
    }
  }

  return lcDp[pairs.length - 1];
};

assert.deepEqual(
  findLongestChain([
    [1, 2],
    [2, 3],
    [3, 4],
  ]),
  2
);
assert.deepEqual(
  findLongestChain([
    [1, 2],
    [7, 8],
    [4, 5],
  ]),
  3
);
assert.deepEqual(
  findLongestChain([
    [1, 2],
    [4, 9],
    [5, 6],
    [7, 8],
  ]),
  3
);

console.log("passed all test cases");
