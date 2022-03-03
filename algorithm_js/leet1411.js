const assert = require('assert');

const numOfWays = (n) => {
  const modulo = Math.pow(10, 9) + 7;
  let aba = 6;
  let abc = 6;

  for (let i = 1; i < n; i++) {
    const tmp = aba;
    aba = (3 * aba + 2 * abc) % modulo;
    abc = (2 * tmp + 2 * abc) % modulo;
  }
  return (aba + abc) % modulo;
};

assert.deepEqual(numOfWays(1), 12);
assert.deepEqual(numOfWays(5000), 30228214);

console.log('All test passed');
