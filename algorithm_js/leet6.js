const assert = require('assert');

const convert = (s, numRows) => {
  let result = '';
  let idx;

  if (numRows <= 1) return s;

  idx = 0;
  while (idx < s.length) {
    result += s[idx];
    idx += 2 * (numRows - 2) + 2;
  }

  for (let i = 0; i < numRows - 2; i++) {
    idx = i + 1;
    flag = true;
    while (idx < s.length) {
      result += s[idx];
      idx += flag ? 2 * (numRows - 2 - i) : 2 * (i + 1);
      flag = !flag;
    }
  }

  idx = numRows - 1;
  while (idx < s.length) {
    result += s[idx];
    idx += 2 * (numRows - 2) + 2;
  }

  return result;
};

assert.deepEqual(convert('PAYPALISHIRING', 3), 'PAHNAPLSIIGYIR');
assert.deepEqual(convert('PAYPALISHIRING', 4), 'PINALSIGYAHRPI');
assert.deepEqual(convert('A', 1), 'A');

console.log('All test passed');
