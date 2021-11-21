const assert = require('assert');

const areSentencesSimilarTwo = (s1, s2, similarPairs) => {
  if (s1.length !== s2.length) return false;

  let next = 1;
  const pairs = {};

  for (let similarPair of similarPairs) {
    const [w1, w2] = similarPair;
    const val1 = pairs[w1];
    const val2 = pairs[w2];

    if (val1 && val2) {
      for (const [word, value] of Object.entries(pairs)) {
        if (value === val2) pairs[word] = val1;
      }
    } else if (val1) {
      pairs[w2] = val1;
    } else if (val2) {
      pairs[w1] = val2;
    } else {
      pairs[w1] = next;
      pairs[w2] = next;
      next++;
    }
  }

  for (let i = 0; i < s1.length; i++) {
    if (s1[i] === s2[i]) continue;
    if (!pairs[s1[i]] || !pairs[s2[i]] || pairs[s1[i]] !== pairs[s2[i]]) return false;
  }
  return true;
};

assert.deepEqual(
  areSentencesSimilarTwo(
    ['great', 'acting', 'skills'],
    ['fine', 'drama', 'talent'],
    [
      ['great', 'good'],
      ['fine', 'good'],
      ['drama', 'acting'],
      ['skills', 'talent'],
    ]
  ),
  true
);
assert.deepEqual(
  areSentencesSimilarTwo(
    ['I', 'love', 'leetcode'],
    ['I', 'love', 'onepiece'],
    [
      ['manga', 'onepiece'],
      ['platform', 'anime'],
      ['leetcode', 'platform'],
      ['anime', 'manga'],
    ]
  ),
  true
);
assert.deepEqual(
  areSentencesSimilarTwo(
    ['I', 'love', 'leetcode'],
    ['I', 'love', 'onepiece'],
    [
      ['manga', 'hunterXhunter'],
      ['platform', 'anime'],
      ['leetcode', 'platform'],
      ['anime', 'manga'],
    ]
  ),
  false
);

console.log('All test passed');
