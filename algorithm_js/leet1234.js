const assert = require("assert");

const getIdx = (char) => {
  switch (char) {
    case "Q":
      return 0;
    case "W":
      return 1;
    case "E":
      return 2;
    case "R":
      return 3;
  }
};

const balancedString = (s) => {
  const counts = { Q: 0, W: 0, E: 0, R: 0 };
  const balanceCount = s.length / 4;

  for (let i = 0; i < s.length; i++) {
    counts[s.charAt(i)] += 1;
  }
  const overflowChars = Object.keys(counts).filter((char) => counts[char] > balanceCount);
  if (!overflowChars.length) return 0;

  const currentCount = new Array(4).fill(0);
  const overflowCounts = new Array(4).fill(0);
  let bestMin = 0;
  for (let char of overflowChars) {
    const diff = counts[char] - balanceCount;
    overflowCounts[getIdx(char)] = diff;
    bestMin += diff;
  }

  let i = 0;
  let j = 1;
  let minReplace = s.length;

  if (overflowChars.includes(s[i])) currentCount[getIdx(s[i])] += 1;

  while (j <= s.length) {
    if (currentCount.every((count, idx) => count >= overflowCounts[idx])) {
      if (minReplace > j - i) {
        minReplace = j - i;
        if (minReplace === bestMin) return bestMin;
      }
      if (overflowChars.includes(s[i])) currentCount[getIdx(s[i])] -= 1;
      i++;
    } else {
      if (overflowChars.includes(s[j])) currentCount[getIdx(s[j])] += 1;
      j++;
    }
  }
  return minReplace;
};

assert.deepEqual(balancedString("QWER"), 0);
assert.deepEqual(balancedString("QQWE"), 1);
assert.deepEqual(balancedString("QQQW"), 2);
assert.deepEqual(balancedString("QQQQ"), 3);
assert.deepEqual(balancedString("WEQERQWQWWRWWERQWEQW"), 4);

console.log("All test passed");
