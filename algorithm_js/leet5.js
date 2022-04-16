const assert = require('assert');

const longestPalindrome = (s) => {
  const expand = (left, right) => {
    while (left >= 0 && right < s.length && s[left] === s[right]) {
      left--;
      right++;
    }
    return right - left - 1;
  };

  let from = 0,
    to = 0;
  for (let i = 0; i < s.length; i++) {
    const oddExpand = expand(i, i);
    const evenExpand = expand(i, i + 1);
    const currMax = Math.max(oddExpand, evenExpand);
    if (currMax > to - from) {
      from = i - Math.floor((currMax - 1) / 2);
      to = i + Math.floor(currMax / 2) + 1;
    }
  }
  return s.slice(from, to);
};

assert.deepEqual(longestPalindrome('babad'), 'bab');
assert.deepEqual(longestPalindrome('cbbd'), 'bb');

console.log('All test passed');
