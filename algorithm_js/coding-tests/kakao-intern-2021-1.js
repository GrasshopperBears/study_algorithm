const assert = require('assert');

const numStrToNum = (s) => {
  let ans = '';
  let pos = 0;
  let strLen = s.length;

  while (pos < strLen) {
    const currentChar = s[pos];
    if (!Number.isNaN(Number(currentChar))) {
      ans += currentChar;
      pos++;
      continue;
    }

    const sFromPos = s.slice(pos);
    if (sFromPos.startsWith('zero')) {
      ans += '0';
      pos += 4;
    } else if (sFromPos.startsWith('one')) {
      ans += '1';
      pos += 3;
    } else if (sFromPos.startsWith('two')) {
      ans += '2';
      pos += 3;
    } else if (sFromPos.startsWith('three')) {
      ans += '3';
      pos += 5;
    } else if (sFromPos.startsWith('four')) {
      ans += '4';
      pos += 4;
    } else if (sFromPos.startsWith('five')) {
      ans += '5';
      pos += 4;
    } else if (sFromPos.startsWith('six')) {
      ans += '6';
      pos += 3;
    } else if (sFromPos.startsWith('seven')) {
      ans += '7';
      pos += 5;
    } else if (sFromPos.startsWith('eight')) {
      ans += '8';
      pos += 5;
    } else if (sFromPos.startsWith('nine')) {
      ans += '9';
      pos += 4;
    }
  }
  return Number(ans);
};

assert.deepEqual(numStrToNum('one4seveneight'), 1478);
assert.deepEqual(numStrToNum('23four5six7'), 234567);
assert.deepEqual(numStrToNum('2three45sixseven'), 234567);
assert.deepEqual(numStrToNum('123'), 123);

console.log('All test passed');
