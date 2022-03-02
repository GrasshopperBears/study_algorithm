const assert = require('assert');

const helper = (s: string, from: number, to: number, dp: number[][]): number => {
  if (to - from < 0) return 0;
  if (to - from === 0) return 1;
  if (dp[from][to] >= 0) return dp[from][to];

  if (s[from] === s[to]) {
    const result = 2 + helper(s, from + 1, to - 1, dp);
    dp[from][to] = result;
    return result;
  }

  const result = Math.max(helper(s, from + 1, to, dp), helper(s, from, to - 1, dp));
  dp[from][to] = result;
  return result;
};

const longestPalindromeSubseq = (s: string): number => {
  const length = s.length;
  const dp = new Array(length).fill(0).reduce((curr) => {
    curr.push(new Array(length).fill(-1));
    return curr;
  }, []);

  return helper(s, 0, length - 1, dp);
};

assert.deepEqual(longestPalindromeSubseq('bbbab'), 4);
assert.deepEqual(longestPalindromeSubseq('cbbd'), 2);

console.log('All test passed');
