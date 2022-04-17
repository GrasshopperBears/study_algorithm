const assert = require('assert');

const atMostNGivenDigitSet = (digits, n) => {
  let result = 0;
  const str = n.toString();
  const strLen = str.length;
  const digitLen = digits.length;

  const visit = (idx) => {
    if (str[idx] === '0') return;
    if (idx === strLen) {
      result++;
      return;
    }
    for (let digit of digits) {
      if (digit < str[idx]) result += Math.pow(digitLen, strLen - idx - 1);
      else if (digit === str[idx]) return visit(idx + 1);
    }
  };
  visit(0);

  for (let j = 1; j <= strLen - 1; j++) result += Math.pow(digitLen, j);

  return result;
};

assert.deepEqual(atMostNGivenDigitSet(['1', '3', '5', '7'], 100), 20);
assert.deepEqual(atMostNGivenDigitSet(['1', '4', '9'], 1000000000), 29523);
assert.deepEqual(atMostNGivenDigitSet(['7'], 8), 1);

console.log('All test passed');
