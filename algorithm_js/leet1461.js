const assert = require("assert");

const hasAllCodes = (s, k) => {
  if (s.length < k) return false;

  const check = new Array(Math.pow(2, k)).fill(false);

  for (let i = 0; i <= s.length - k; i++) {
    const target = s.slice(i, i + k);
    check[parseInt(target, 2)] = true;
  }
  return check.every((idx) => idx);
};

assert.deepEqual(hasAllCodes("00110110", 2), true);
assert.deepEqual(hasAllCodes("00110", 2), true);
assert.deepEqual(hasAllCodes("0110", 1), true);
assert.deepEqual(hasAllCodes("0110", 2), false);
assert.deepEqual(hasAllCodes("0000000001011100", 4), false);

console.log("All test passed");
