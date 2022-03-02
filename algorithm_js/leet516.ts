const assert = require('assert');

const longestPalindromeSubseq = (s: string): number => {
  const length = s.length;
  const dp = new Array(length).fill(0).reduce((curr, _, idx) => {
    curr.push(new Array(idx + 1).fill(-1));
    return curr;
  }, []);

  const helper = (s: string, from: number, to: number): number => {
    let result;

    if (to - from < 0) result = 0;
    else if (to - from === 0) result = 1;
    else if (dp[from][to] >= 0) return dp[from][to];
    else if (s[from] === s[to]) result = 2 + helper(s, from + 1, to - 1);
    else result = Math.max(helper(s, from + 1, to), helper(s, from, to - 1));

    dp[from][to] = result;
    return result;
  };

  helper(s, 0, length - 1);

  return dp[0][length - 1];
};

assert.deepEqual(longestPalindromeSubseq('bbbab'), 4);
assert.deepEqual(longestPalindromeSubseq('cbbd'), 2);

console.log('All test passed');
