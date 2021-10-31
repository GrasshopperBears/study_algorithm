const assert = require('assert');

const reverseWords = (s) => {
  let iPrev = (i = 0);
  let jPrev = (j = s.length - 1);

  while (j >= i) {
    if (s[i] === ' ' && s[j] === ' ') {
      const lenDiff = jPrev - j - (i - iPrev);
      const right = s.splice(j + 1, jPrev - j, ...s.slice(iPrev, i));
      s.splice(iPrev, i - iPrev, ...right);
      j = jPrev = j - 1 + lenDiff;
      i = iPrev = i + 1 + lenDiff;
    } else if (s[i] === ' ') {
      j--;
    } else if (s[j] === ' ') {
      i++;
    } else {
      i++;
      j--;
    }
  }
};

const test1 = ['t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'];
reverseWords(test1);
assert.deepEqual(test1, ['b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e']);

const test2 = ['a'];
reverseWords(test2);
assert.deepEqual(test2, ['a']);

console.log('All test passed');
