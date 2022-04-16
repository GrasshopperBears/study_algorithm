const assert = require('assert');

const OFFSET = 97;

const compare = (arr1, arr2) => {
  for (let i = 0; i < arr1.length; i++) {
    if (arr1[i] !== arr2[i]) return false;
  }
  return true;
};

const findAnagrams = (s, p) => {
  if (s.length < p.length) return [];

  const count = new Array(26).fill(0);
  const current = new Array(26).fill(0);
  const result = [];
  let last = 0;

  for (let i = 0; i < p.length; i++) {
    count[p.charCodeAt(i) - OFFSET]++;
  }

  for (let i = 0; i < s.length; i++) {
    current[s.charCodeAt(i) - OFFSET]++;
    if (i - last + 1 === p.length) {
      if (compare(count, current)) result.push(last);
      current[s.charCodeAt(last) - OFFSET]--;
      last++;
    }
  }

  return result;
};

assert.deepEqual(findAnagrams('cbaebabacd', 'abc'), [0, 6]);
assert.deepEqual(findAnagrams('abab', 'ab'), [0, 1, 2]);

console.log('All test passed');
