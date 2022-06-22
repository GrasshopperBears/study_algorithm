const assert = require('assert');

const constructDistancedSequence = (n) => {
  const result = new Array(2 * n - 1).fill(0);
  const using = new Set();

  const use = (idx) => {
    if (idx === result.length) return true;
    if (result[idx]) return use(idx + 1);

    for (let i = n; i > 0; i--) {
      if (using.has(i)) continue;
      result[idx] = i;
      using.add(i);

      if (i === 1) {
        if (use(idx + 1)) return true;
      } else if (idx + i < result.length && !result[idx + i]) {
        result[idx + i] = i;
        if (use(idx + 1)) return true;
        result[idx + i] = 0;
      }
      using.delete(i);
      result[idx] = 0;
    }
    return false;
  };
  use(0);
  return result;
};

assert.deepEqual(constructDistancedSequence(3), [3, 1, 2, 3, 2]);
assert.deepEqual(constructDistancedSequence(5), [5, 3, 1, 4, 3, 5, 2, 4, 2]);

console.log('All test passed');
