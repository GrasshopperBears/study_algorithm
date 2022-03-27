const assert = require('assert');

class WordDistance {
  constructor(wordsDict) {
    this.wordMap = new Map();
    for (let i = 0; i < wordsDict.length; i++) {
      const prev = this.wordMap.get(wordsDict[i]);
      this.wordMap.set(wordsDict[i], prev ? [...prev, i] : [i]);
    }
  }

  shortest(word1, word2) {
    const word1Indices = this.wordMap.get(word1);
    const word2Indices = this.wordMap.get(word2);
    let i = 0,
      j = 0;
    let minDist = Math.abs(word1Indices[i] - word2Indices[j]);

    while (i < word1Indices.length || j < word2Indices.length) {
      let currDist;
      if (i === word1Indices.length) {
        currDist = Math.abs(word1Indices[i - 1] - word2Indices[j++]);
      } else if (j === word2Indices.length) {
        currDist = Math.abs(word1Indices[i++] - word2Indices[j - 1]);
      } else {
        const dist = word1Indices[i] - word2Indices[j];
        if (dist < 0) i++;
        else if (dist > 0) j++;
        else return 0;
        currDist = Math.abs(dist);
      }
      minDist = Math.min(minDist, currDist);
    }

    return minDist;
  }
}

const test1 = new WordDistance(['practice', 'makes', 'perfect', 'coding', 'makes']);
assert.deepEqual(test1.shortest('coding', 'practice'), 3);
assert.deepEqual(test1.shortest('makes', 'coding'), 1);

console.log('All test passed');
